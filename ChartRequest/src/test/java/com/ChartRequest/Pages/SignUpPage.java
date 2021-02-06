package com.ChartRequest.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SignUpPage extends BrowserConfiguration {

	ReadOTPFromOnlineMobileNumber readOtpFromMobileNumber = new ReadOTPFromOnlineMobileNumber();

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//u[contains(text(),'Sign up as a Patient')]")
	WebElement signUpPatient;

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='user_middle_name']")
	WebElement MiddleName;

	@FindBy(xpath = "//input[@id='user_last_name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='user_date_of_birth']")
	WebElement DateofBirth;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='confirm_email_address']")
	WebElement confrimEmailAddress;

	@FindBy(xpath = "//input[@id='user_password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='user_password_confirmation']")
	WebElement confrimPassword;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	WebElement ImnotaRobot;

	@FindBy(xpath = "//input[@id='eposta_adres']")
	WebElement tempEmailId;

	@FindBy(id = "details-button")
	WebElement advanceButton;

	@FindBy(xpath = "//a[text()='Proceed to staging.chartrequest.com (unsafe)']")
	WebElement unsecureLink;

	@FindBy(xpath = "//button[@id='create-account-btn']")
	WebElement createMyAccount;

	@FindBy(xpath = "//input[@id='organization_address']")
	WebElement addressLine1;

	@FindBy(xpath = "//input[@id='organization_address2']")
	WebElement addressLine2;

	@FindBy(xpath = "//input[@id='organization_city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='organization_zipcode']")
	WebElement zipCode;

	@FindBy(xpath = "//button[@id='add-address-btn']")
	WebElement patientContuineButton;

	@FindBy(xpath = "//button[@id='organization-info-btn']")
	WebElement contuineButton;

	@FindBy(xpath = "//label[contains(text(),'Email :')]//input[@name='verify_type']")
	WebElement verifyByEmail;

	@FindBy(xpath = "//label[contains(text(),'Text')]//input[@name='verify_type']")
	WebElement verifyByText;

	@FindBy(xpath = "//button[@id='verify-account-btn']")
	WebElement sendVerificationCode;

	@FindBy(xpath = "//input[@id='organization_phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//u[contains(text(),'Sign up as a Professional')]")
	WebElement signUpAsaProfessional;

	@FindBy(xpath = "//label[contains(text(),'Yes')]")
	WebElement yesRadioButton;

	@FindBy(xpath = "//label[contains(text(),'No')]")
	WebElement noRadioButton;

	@FindBy(xpath = "//h2[contains(text(),'Organization Exists with ChartRequest')]")
	WebElement existingOrganization;

	@FindBy(xpath = "//input[@id='searchOrganization']")
	WebElement searchOrganizationInput;

	@FindBy(xpath = "//div[@class='tbl-content']//following::tr[@id='cust_options']")
	WebElement selectSearchedOrganization;

	@FindBy(xpath = "//div[@class='tableFooterWrap modal-footer']//button[@id='invite-me-btn']")
	WebElement inviteMeButton;

	@FindBy(xpath = "//button[@class='singUpBtn']")
	WebElement notYourOrganizationButton;

	@FindBy(xpath = "//input[@id='organization_npi_number']")
	WebElement inputOrganizationNpiNumber;

	@FindBy(xpath = "//input[@id='organization_name']")
	WebElement inputOrganizationAddress;

	@FindBy(id = "survey_no_of_attorneys_1_-_5")
	WebElement radioButtonRequestorSurveyAttorney1to5;

	@FindBy(id = "survey_no_of_attorneys_6_-_20")
	WebElement radioButtonRequestorSurveyAttorney6to20;

	@FindBy(id = "survey_no_of_attorneys_21_-_50")
	WebElement radioButtonRequestorSurveyAttorney21to50;

	@FindBy(id = "survey_no_of_attorneys_51-_100")
	WebElement radioButtonRequestorSurveyAttorney51to100;

	@FindBy(id = "survey_no_of_attorneys_100_")
	WebElement radioButtonRequestorSurveyAttorney100Plus;

	@FindBy(id = "survey_no_of_professionals_1_-_5")
	WebElement radioButtonRequestorSurveyProfessionals1to5;

	@FindBy(id = "survey_no_of_professionals_6_-_20")
	WebElement radioButtonRequestorSurveyProfessionals6to20;

	@FindBy(id = "survey_no_of_professionals_21_-_50")
	WebElement radioButtonRequestorSurveyProfessionals21to50;

	@FindBy(id = "survey_no_of_professionals_51-_100")
	WebElement radioButtonRequestorSurveyProfessionals51to100;

	@FindBy(id = "survey_no_of_professionals_100_")
	WebElement radioButtonRequestorSurveyProfessionals100;

	@FindBy(xpath = "//input[@id='survey_payment_Yes']")
	WebElement radioButtonSurveyPaymentYes;

	@FindBy(xpath = "//input[@id='survey_payment_No']")
	WebElement radioButtonSurveyPaymentNo;

	@FindBy(xpath = "//input[@id='payment_name']")
	WebElement inputRequestorPaymentName;

	@FindBy(xpath = "//input[@id='payment_title']")
	WebElement inputRequestorPaymentTitle;

	@FindBy(xpath = "//input[@id='leverage']")
	WebElement inputRequestorLeverage;

	@FindBy(id = "survey_firm_0_-_10_week")
	WebElement radioRequestperWeek0to10;

	@FindBy(id = "survey_firm_11_-_25_week")
	WebElement radioRequestperWeek11to25;

	@FindBy(id = "survey_firm_26_-_50_week")
	WebElement radioRequestperWeek26to50;

	@FindBy(id = "survey_firm_51__week")
	WebElement radioRequestperWeek51Plus;

	@FindBy(id = "survey_case_1")
	WebElement radioRequestMedicalRecordsFromperCase1;

	@FindBy(id = "survey_case_2_-_4")
	WebElement radioRequestMedicalRecordsFromperCase2to4;

	@FindBy(id = "survey_case_5_-_10")
	WebElement radioRequestMedicalRecordsFromperCase5to10;

	@FindBy(id = "survey_case_10_")
	WebElement radioRequestMedicalRecordsFromperCase10Plus;

	@FindBy(xpath = "//button[contains(text(),'Add Signature')]")
	WebElement addSignatureButtonRequestorSurvey;

	@FindBy(xpath = "//input[@id='sign_name']")
	WebElement addSignNameInput;

	@FindBy(xpath = "//button[@id='adopt-save-btn']")
	WebElement adoptAndSignButton;

	@FindBy(xpath = "//button[@id='skip-low-firm-logo-btn']")
	WebElement uplaodLogoLater;

	@FindBy(xpath = "//input[@id='website_url']")
	WebElement inputCompanyWebsite;

	@FindBy(xpath = "//input[@id='survey_invite_more_Yes']")
	WebElement radioButtonInviteMoreUserYes;

	@FindBy(xpath = "//input[@id='survey_invite_more_No']")
	WebElement radioButtonInviteMoreUserNo;

	@FindBy(xpath = "//button[@id='low-firm-survey-btn']")
	WebElement doneButton;

	@FindBy(xpath = "//button[@id='low-firm-survey-btn']")
	WebElement inputInviteUserWithEmail;

	@FindBy(xpath = "//i[@class='fas fa-plus add_more_invite']")
	WebElement addNewUserSurveySignupPlusSign;

	@FindBy(xpath = "//input[@id='confirm_code']")
	WebElement inputOTP;

	@FindBy(xpath = "//input[@id='signup_terms']")
	WebElement checkboxPrivacyPolicy;

	@FindBy(xpath = "//input[@id='signup_policy']")
	WebElement checkboxThirdParty;

	@FindBy(xpath = "//button[@id='confirm-identity-btn']")
	WebElement buttonConfrimAndLogin;

	@FindBy(xpath = "//input[@id='survey_invite_more_No']")
	WebElement radioButtonNoInviteMoreUser;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement buttonInvite;

	@FindBy(xpath = "//input[@id='organization_name']")
	WebElement inputOrganizationName;

	@FindBy(xpath = "//div[@class='form-group col-sm-12']//label[@class='radio-inline'][contains(text(),'Yes')]")
	WebElement agreeToTheHipaaBusinessAssociateAgreementBAAYes;

	@FindBy(xpath = "//div[@class='form-group col-sm-12']//label[@class='radio-inline'][contains(text(),'No')]")
	WebElement agreeToTheHipaaBusinessAssociateAgreementBAANo;

	@FindBy(xpath = "//input[@id='authorized_name']")
	WebElement hippaBusinessdetailsName;

	@FindBy(xpath = "//input[@id='authorized_title']")
	WebElement hippaBusinessdetailstitle;

	@FindBy(xpath = "//input[@id='authorized_email']")
	WebElement hippaBusinessdetailsEmail;

	@FindBy(xpath = "//input[@id='authorized_phone']")
	WebElement hippaBusinessdetailsPhoneNo;

	@FindBy(xpath = "//button[@id='agree-baa-btn']")
	WebElement iAgreetoTheBAA;

	@FindBy(xpath = "//button[@id='not-agree-baa-btn']")
	WebElement iNotAgreetoTheBAA;

	@FindBy(xpath = "//input[@id='ce_survey_type_Yes']")
	WebElement careCorrdinationAgreement;

	@FindBy(xpath = "//input[@class='ce-accpet-chk']")
	WebElement checkBoxAgreeAgrement;

	@FindBy(xpath = "//button[@id='agree-ce-btn']")
	WebElement iAgreeButtonCareCoordinationAgreement;

	@FindBy(xpath = "//input[@id='sign_name']")
	WebElement autorizerName;

	@FindBy(xpath = "//a[@id='adopt-save-btn']")
	WebElement acceptTheForm;

	@FindBy(xpath = "//input[@id='ce_authorized_name']")
	WebElement inputCareCordinationAuthorizedName;

	@FindBy(xpath = "//input[@id='ce_authorized_name']")
	WebElement inputCareCordinationAuthorizedTitle;

	@FindBy(xpath = "//input[@id='ce_authorized_email']")
	WebElement inputCareCordinationAuthorizedEmail;

	@FindBy(xpath = "//input[@id='ce_authorized_phone']")
	WebElement inputCareCordinationAuthorizedPhone;

	@FindBy(xpath = "//input[@value='1-9']")
	WebElement sizeofOrganizationCustodian1to9;

	@FindBy(xpath = "//input[@value='10-30']")
	WebElement sizeofOrganizationCustodian10to30;

	@FindBy(xpath = "//input[@value='31-100']")
	WebElement sizeofOrganizationCustodian31to100;

	@FindBy(xpath = "//input[@id='survey_size_101_']")
	WebElement sizeofOrganizationCustodianMoreThan100;

	@FindBy(xpath = "//input[@id='survey_average___30']")
	WebElement recordsLessThan30;

	@FindBy(xpath = "//input[@id='survey_average_30-150']")
	WebElement recordsbetween30to150;

	@FindBy(xpath = "//input[@id='survey_average___150']")
	WebElement recordsMoreThan150;

	@FindBy(xpath = "//input[@id='survey_charge_Yes']")
	WebElement radioButtonChargesForTheRecordsYes;

	@FindBy(xpath = "//input[@id='survey_charge_No']")
	WebElement radioButtonChargesForTheRecordsNo;

	@FindBy(xpath = "")
	WebElement skipTheQuestion6;

	@FindBy(xpath = "//input[@id='survey_release_onboarding_session_time']")
	WebElement inputFromOurOffice;

	@FindBy(xpath = "//input[@id='survey_release_HIM']")
	WebElement inputFromHimoffice;

	@FindBy(xpath = "//input[@id='survey_release_vendor']")
	WebElement input3rdPartyVendor;

	@FindBy(xpath = "//a[@id='no-thanks-btn']")
	WebElement inputRequestonDemo;

	public String getTemporaryEmailIDWebsite() {
		return tempEmailId.getAttribute("value");
	}

	public void openApplicationURL() {
		advanceButton.click();
		unsecureLink.click();
	}

	public void selectGender(String selectGender) {
		Select selectSize = new Select(driver.findElement(By.name("user[gender]")));
		selectSize.selectByVisibleText(selectGender);
	}

	public void selectState(String State) {
		Select selectState = new Select(driver.findElement(By.name("organization[state]")));
		selectState.selectByVisibleText(State);
	}

	public void selectRobot() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
				"//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border")))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
				"//iframe[starts-with(@name, 'c-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		System.out.println("At Captacha Verify");
		boolean flag = true;
		int i = 1;
		while (flag) {
			boolean visibleButton = driver.findElement(By.xpath("//button[@id='solver-button']")).isDisplayed();
			if (visibleButton) {
				new WebDriverWait(driver, 20)
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='solver-button']")))
						.click();
				TestUtil.hardWait(7);
				System.out.println("Click on Cpatcha Button: " + i);
				i++;
			} else {
				flag = false;
			}

		}

	}

	public void signUpApplicationAsPatient(String firstName, String middleName, String lastName, String gender,
			String DOB, String emailID, String confrimEmailID, String inputPassword, String inputConfrimPassword,
			String address1, String address2, String City, String state, String ZipCode, String PhoneNumber) {
		try {
			signUpPatient.click();
			FirstName.sendKeys(firstName);
			TestListener.infoMessage("First Name:- "+firstName);
			MiddleName.sendKeys(middleName);
			TestListener.infoMessage("Middle Name:- "+middleName);
			LastName.sendKeys(lastName);
			TestListener.infoMessage("Last Name:- "+lastName);
			selectGender(gender);
			TestListener.infoMessage("Gender:- "+gender);
			DateofBirth.sendKeys(DOB);
			TestListener.infoMessage("Date of Birth:- "+DOB);
			emailAddress.sendKeys(emailID);
			TestListener.infoMessage("Email ID:- "+emailID);
			confrimEmailAddress.sendKeys(confrimEmailID);
			TestListener.infoMessage("Confrim Email ID:- "+confrimEmailID);
			password.sendKeys(inputPassword);
			confrimPassword.sendKeys(inputConfrimPassword);
			confrimPassword.sendKeys(Keys.TAB);
			TestUtil.hardWait(5);
			TestUtil.swtichToDefaultFrame();
			createMyAccount.click();
			addressLine1.sendKeys(address1);
			addressLine2.sendKeys(address2);
			city.sendKeys(City);
			selectState(state);
			zipCode.sendKeys(ZipCode);
			patientContuineButton.click();
			phoneNumber.sendKeys(PhoneNumber);
			TestListener.infoMessage("Phone Number:- "+PhoneNumber);
			verifyByText.click();
			sendVerificationCode.click();
			TestUtil.swtichToTab(1);
			String otpNumber = readOtpFromMobileNumber.getOTPNumber();
			TestUtil.swtichToTab(0);
			inputOTP.sendKeys(otpNumber);
			checkboxPrivacyPolicy.click();
			checkboxThirdParty.click();
			buttonConfrimAndLogin.click();
			radioButtonNoInviteMoreUser.click();
			buttonInvite.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void signUpApplicationAsRequestor(String firstName, String middleName, String lastName, String emailID,
			String confrimEmailID, String inputPassword, String inputConfrimPassword, String searchOrganizationName,
			Boolean inviteMeButton, String OrganizationRequestorType, String organizationName, String address1,
			String address2, String City, String state, String ZipCode, String PhoneNumber, String OpenURL) {
		try {
			signUpAsaProfessional.click();
			FirstName.sendKeys(firstName);
			MiddleName.sendKeys(middleName);
			LastName.sendKeys(lastName);
			emailAddress.sendKeys(emailID);
			confrimEmailAddress.sendKeys(confrimEmailID);
			password.sendKeys(inputPassword);
			confrimPassword.sendKeys(inputConfrimPassword);
			confrimPassword.sendKeys(Keys.TAB);
			createMyAccount.click();
			selectExistingOrganzation(searchOrganizationName, inviteMeButton);
			noRadioButton.click();
			selectOrganizationType(OrganizationRequestorType);
			inputOrganizationName.sendKeys(organizationName);
			addressLine1.sendKeys(address1);
			addressLine2.sendKeys(address2);
			city.sendKeys(City);
			selectState(state);
			zipCode.sendKeys(ZipCode);
			contuineButton.click();
			phoneNumber.sendKeys(PhoneNumber);
			verifyByText.click();
			sendVerificationCode.click();
			TestUtil.swtichToTab(1);
			String otpNumber = readOtpFromMobileNumber.getOTPNumber();
			TestUtil.swtichToTab(0);
			inputOTP.sendKeys(otpNumber);
			checkboxPrivacyPolicy.click();
			checkboxThirdParty.click();
			buttonConfrimAndLogin.click();
			System.out.println(organizationName + " Survey Questions");
			surveyFormRequestorAttorney(true, false, false, false, false);
			surveyFormRequestorProfessional(true, false, false, false, false);
			selectResposibleForRetrievingMedical("Lawyer");
			responsibleForMakingPayment(true, "", "");
			managementSoftwareLeverage("JIRA");
			recordsPerWeek(true, false, false, false);
			providerRequestMedicalFromPerCase(true, false, false, false);
			addSignature("Automation");
			addlogoORLetterHead();
			addcompnayWebsite("https://www.google.co.in/");
			inviteMoreUser(true, false, "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void signUpApplicationAsCustodian(String firstName, String middleName, String lastName, String emailID,
			String confrimEmailID, String inputPassword, String inputConfrimPassword, String searchOrganizationName,
			Boolean inviteMeButton, String OrganizationNpiNumber, String organizationName, String address1,
			String address2, String City, String state, String ZipCode, String PhoneNumber, String OpenURL) {
		signUpAsaProfessional.click();
		FirstName.sendKeys(firstName);
		MiddleName.sendKeys(middleName);
		LastName.sendKeys(lastName);
		emailAddress.sendKeys(emailID);
		confrimEmailAddress.sendKeys(confrimEmailID);
		password.sendKeys(inputPassword);
		confrimPassword.sendKeys(inputConfrimPassword);
		confrimPassword.sendKeys(Keys.TAB);
		createMyAccount.click();
		selectExistingOrganzation(searchOrganizationName, inviteMeButton);
		yesRadioButton.click();
		inputOrganizationNpiNumber.sendKeys(OrganizationNpiNumber);
		inputOrganizationAddress.sendKeys(organizationName);
		addressLine1.sendKeys(address1);
		addressLine2.sendKeys(address2);
		city.sendKeys(City);
		selectState(state);
		zipCode.sendKeys(ZipCode);
		contuineButton.click();
		phoneNumber.sendKeys(PhoneNumber);
		verifyByText.click();
		sendVerificationCode.click();
		TestUtil.swtichToTab(1);
		String otpNumber = readOtpFromMobileNumber.getOTPNumber();
		TestUtil.swtichToTab(0);
		inputOTP.sendKeys(otpNumber);
		checkboxPrivacyPolicy.click();
		checkboxThirdParty.click();
		buttonConfrimAndLogin.click();
		System.out.println(organizationName + " Survey Questions");
		selectAgreeToHipaaBusinessAssociate(true, "", "", "", "");
		agreeCareCoordinationAgreement(true, "Automation", "", "", "", "");
		surveyFormCustodianNoOfProviders(true, false, false, false);
		surveyFormCustodianrecordsReceiveOnAverage(true, false, false);
		chargePatientForMedicalRecords(true);
		typeofRecords(true);
		releaseRecords(true, false, false);
		RequestDemo();
	}

	public void selectOrganizationType(String organizationRequestorType) {
		Select selectState = new Select(driver.findElement(By.id("organization_requestor_type")));
		selectState.selectByVisibleText(organizationRequestorType);
	}

	public void selectExistingOrganzation(String searchOrganization, boolean inviteMe) {
		try {
			if (TestUtil.isElementDisplayed(existingOrganization)) {
				if (inviteMe) {
					searchOrganizationInput.sendKeys(searchOrganization);
					searchOrganizationInput.sendKeys(Keys.ENTER);
					selectSearchedOrganization.click();
					inviteMeButton.click();
				} else {
					notYourOrganizationButton.click();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Question 1 Requestor
	public void surveyFormRequestorAttorney(boolean attorney1to5, boolean attorney6to20, boolean attorney21to50,
			boolean attorney51to100, boolean attorney100Plus) {
		if (attorney1to5) {
			radioButtonRequestorSurveyAttorney1to5.click();
		}
		if (attorney6to20) {
			radioButtonRequestorSurveyAttorney6to20.click();
		}
		if (attorney21to50) {
			radioButtonRequestorSurveyAttorney21to50.click();
		}
		if (attorney51to100) {
			radioButtonRequestorSurveyAttorney51to100.click();
		}
		if (attorney100Plus) {
			radioButtonRequestorSurveyAttorney100Plus.click();
		}
	}

	// Question 2 Requestor
	public void surveyFormRequestorProfessional(boolean professional1to5, boolean professional6to20,
			boolean professional21to50, boolean professional51to100, boolean professional100Plus) {
		if (professional1to5) {
			radioButtonRequestorSurveyProfessionals1to5.click();
		}
		if (professional6to20) {
			radioButtonRequestorSurveyProfessionals6to20.click();
		}
		if (professional21to50) {
			radioButtonRequestorSurveyProfessionals21to50.click();
		}
		if (professional51to100) {
			radioButtonRequestorSurveyProfessionals51to100.click();
		}
		if (professional100Plus) {
			radioButtonRequestorSurveyProfessionals100.click();
		}
	}

	// Question 3 Requestor
	public void selectResposibleForRetrievingMedical(String responsibleForRetrieveingMedical) {
		Select selectState = new Select(driver.findElement(By.id("survey_responsible")));
		selectState.selectByVisibleText(responsibleForRetrieveingMedical);
	}

	// Question 4 Requestor
	public void responsibleForMakingPayment(boolean responsibleForMakingPaymentYes, String requestorPaymentName,
			String requestorPaymentTitle) {
		if (responsibleForMakingPaymentYes) {
			radioButtonSurveyPaymentYes.click();
		} else {
			radioButtonSurveyPaymentNo.click();
			inputRequestorPaymentName.sendKeys(requestorPaymentName);
			inputRequestorPaymentTitle.sendKeys(requestorPaymentTitle);
		}
	}

	// Question 5 Requestor
	public void managementSoftwareLeverage(String softwareLeverage) {
		inputRequestorLeverage.sendKeys(softwareLeverage);
	}

	// Question 6 Requestor
	public void recordsPerWeek(boolean requestperWeek0to10, boolean requestperWeek11to25, boolean requestperWeek26to50,
			boolean requestperWeek51Plus) {
		if (requestperWeek0to10) {
			radioRequestperWeek0to10.click();
		}
		if (requestperWeek11to25) {
			radioRequestperWeek11to25.click();
		}
		if (requestperWeek26to50) {
			radioRequestperWeek26to50.click();
		}
		if (requestperWeek51Plus) {
			radioRequestperWeek51Plus.click();
		}
	}

	// Question 7 Requestor
	public void providerRequestMedicalFromPerCase(boolean requestperWeek0to10, boolean requestperWeek11to25,
			boolean requestperWeek26to50, boolean requestperWeek51Plus) {
		if (requestperWeek0to10) {
			radioRequestMedicalRecordsFromperCase1.click();
		}
		if (requestperWeek11to25) {
			radioRequestMedicalRecordsFromperCase2to4.click();
		}
		if (requestperWeek26to50) {
			radioRequestMedicalRecordsFromperCase5to10.click();
		}
		if (requestperWeek51Plus) {
			radioRequestMedicalRecordsFromperCase10Plus.click();
		}
	}

	// Question 8 Requestor
	public void addSignature(String addSignatureName) {
		addSignatureButtonRequestorSurvey.click();
		addSignNameInput.sendKeys(addSignatureName);
		adoptAndSignButton.click();
	}

	// Question 9 Requestor
	public void addlogoORLetterHead() {
		uplaodLogoLater.click();
	}

	// Question 10 Requestor
	public void addcompnayWebsite(String companyWebsite) {
		inputCompanyWebsite.sendKeys(companyWebsite);
	}

	// Question 11 Requestor
	public void inviteMoreUser(boolean inviteMoreUserToAdd, boolean addNewUserWithRole, String newEmailID) {
		if (inviteMoreUserToAdd) {
			radioButtonInviteMoreUserNo.click();
			doneButton.click();
		} else {
			radioButtonInviteMoreUserYes.click();
			inputInviteUserWithEmail.sendKeys(newEmailID);
			if (addNewUserWithRole) {
				addNewUserSurveySignupPlusSign.click();
				doneButton.click();
			}
		}
	}

	public void selectUserRole(String roleName) {
		Select select = new Select(driver.findElement(By.id("requestor_user_roles_1")));
		select.selectByVisibleText(roleName);
	}

	// Question 1 Professional Survey
	public void selectAgreeToHipaaBusinessAssociate(boolean YesHippa, String autorizedName, String autorizedTitle,
			String emailId, String phoneNo) {
		if (YesHippa) {
			agreeToTheHipaaBusinessAssociateAgreementBAAYes.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", iAgreetoTheBAA);
			iAgreetoTheBAA.click();
		} else {
			agreeToTheHipaaBusinessAssociateAgreementBAANo.click();
			hippaBusinessdetailsName.sendKeys(autorizedName);
			hippaBusinessdetailstitle.sendKeys((autorizedTitle));
			hippaBusinessdetailsEmail.sendKeys(emailId);
			hippaBusinessdetailsPhoneNo.sendKeys(phoneNo);
		}
	}

	// Question 2 Custodian Professional Survey
	public void agreeCareCoordinationAgreement(boolean agreeCareCordination, String authorizedName,
			String careCordinationAuthorizedName, String careCordinationAuthorizedTitle,
			String careCordinationAuthorizedEmail, String careCordinationAuthorizedPhone) {
		if (agreeCareCordination) {
			careCorrdinationAgreement.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			checkBoxAgreeAgrement.click();
			iAgreeButtonCareCoordinationAgreement.click();
			autorizerName.sendKeys(authorizedName);
			acceptTheForm.click();
		} else {
			inputCareCordinationAuthorizedName.sendKeys(careCordinationAuthorizedName);
			inputCareCordinationAuthorizedTitle.sendKeys(careCordinationAuthorizedTitle);
			inputCareCordinationAuthorizedEmail.sendKeys(careCordinationAuthorizedEmail);
			inputCareCordinationAuthorizedPhone.sendKeys(careCordinationAuthorizedPhone);
		}
	}

	// Question 3 Custodian Professional Survey
	public void surveyFormCustodianNoOfProviders(boolean professional1to9, boolean professional0to30,
			boolean professional31to100, boolean professional100Plus) {
		if (professional1to9) {
			sizeofOrganizationCustodian1to9.click();
		}
		if (professional0to30) {
			sizeofOrganizationCustodian10to30.click();
		}
		if (professional31to100) {
			sizeofOrganizationCustodian31to100.click();
		}
		if (professional100Plus) {
			sizeofOrganizationCustodianMoreThan100.click();
		}
	}

	// Question 4 Custodian Professional Survey
	public void surveyFormCustodianrecordsReceiveOnAverage(boolean lessThan30, boolean between30to150,
			boolean professionalmoreThan150) {
		if (lessThan30) {
			recordsLessThan30.click();
		}
		if (between30to150) {
			recordsbetween30to150.click();
		}
		if (professionalmoreThan150) {
			recordsMoreThan150.click();
		}
	}

	// Question 5 Custodian Professional Survey
	public void chargePatientForMedicalRecords(Boolean chargesForMedicalRecords) {
		if (chargesForMedicalRecords) {
			radioButtonChargesForTheRecordsYes.click();
		} else {
			radioButtonChargesForTheRecordsNo.click();
		}
	}

	// Question 6 Custodian Professional Survey
	public void typeofRecords(Boolean skipTheQuestion) {
		if (skipTheQuestion) {
			skipTheQuestion6.click();
			System.out.println("Pending");
		} else {
			System.out.println("Not Desgined the Function");
		}
	}

	// Question 7 Custodian Professional Survey
	public void releaseRecords(boolean fromOurOffice, boolean fromHIMOffice, boolean by3rdPartyVendor) {
		if (fromOurOffice) {
			inputFromOurOffice.click();
		}
		if (fromHIMOffice) {
			inputFromHimoffice.click();
		}
		if (by3rdPartyVendor) {
			input3rdPartyVendor.click();
		}
	}

	// Question 8 Custodian Professional Survey
	public void RequestDemo() {
		inputRequestonDemo.click();
		doneButton.click();
	}

}
