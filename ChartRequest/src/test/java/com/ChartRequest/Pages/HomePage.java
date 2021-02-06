package com.ChartRequest.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class HomePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	CreateRequest createRequest=new CreateRequest();

	public HomePage() {
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

	@FindBy(xpath = "//button[contains(text(),'Request Records')]")
	WebElement searchRequestorNameButton;

	@FindBy(xpath = "//li[@id='your_account']/a[@href='/account']")
	WebElement tabMyAccount;

	@FindBy(xpath = "//dt[text()='Email']/following::dd[1]")
	WebElement getUserEmailId;

	@FindBy(xpath = "//a[contains(text(),'Messages')]")
	public WebElement navigationTabMessage;

	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	WebElement myAccountEditButton;

	@FindBy(xpath = "//input[@id='current_user_name']")
	WebElement myAccountEditFirstNameInput;

	@FindBy(xpath = "//input[@id='current_user_middle_name']")
	WebElement myAccountEditMiddleNameInput;

	@FindBy(xpath = "//input[@id='current_user_last_name']")
	WebElement myAccountEditLastNameInput;

	@FindBy(xpath = "//input[@id='current_user_email']")
	WebElement myAccountEditEmailIDInput;

	@FindBy(xpath = "//input[@id='current_user_original_password']")
	WebElement myAccountEditOrginalPasswordInput;

	@FindBy(xpath = "//input[@id='current_user_new_password']")
	WebElement myAccountEditNewPasswordInput;

	@FindBy(xpath = "//input[@id='current_user_new_password_confirmation']")
	WebElement myAccountEditNewConfrimPasswordInput;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//dt[contains(text(),'Name')]")
	WebElement labelForWait;

	@FindBy(xpath = "//ul[@class='chosen-choices']")
	WebElement inputFavoriteProvider;

	@FindBy(xpath = "//input[@value='Select Provider']")
	WebElement inputFavoriteProviderValue;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[1]/ul/li")
	WebElement listFavoriteProvider;

	@FindBy(xpath = "//input[@id='current_user_date_of_birth']")
	WebElement inputDateofBirth;

	@FindBy(xpath = "//*[@id='your_account']//a[@href='/my_organization']")
	WebElement navigationTabMyOrganization;

	@FindBy(xpath = "//a[contains(text(),'Invite Your Colleagues')]")
	WebElement buttonInviteYourColleagues;

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement inputInviteYourColleaguesFirstName;

	@FindBy(xpath = "//input[@id='user_last_name']")
	WebElement inputInviteYourColleaguesLastName;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement inputInviteYourColleaguesEmailId;

	@FindBy(xpath = "//input[@id='user_user_verify_phone']")
	WebElement inputInviteYourColleaguesPhoneNumber;

	@FindBy(xpath = "//input[@id='user_date_of_birth']")
	WebElement inputInviteYourColleaguesDateofBirth;

	@FindBy(xpath = "//input[@id='fullname']")
	WebElement inputInviteYourColleaguesFullName;

	@FindBy(xpath = "//input[@id='initials']")
	WebElement inputInviteYourColleaguesInitials;

	@FindBy(xpath = "//input[@class='checkbox-not-matched-email']")
	WebElement inputInviteYourColleaguesCheckbox;

	@FindBy(xpath = "//button[@id='invite_user']")
	WebElement buttonInviteYourColleaguesSendInvitation;

	@FindBy(xpath = "//dt[text()='Address']/preceding::dd[1]")
	WebElement noOfUser;
	
	@FindBy(xpath = "//a[contains(text(),'Available Credit Cards')]")
	WebElement buttonAvailableCreditCards;
	
	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
	WebElement buttonDropDownChooseAction;
	
	@FindBy(xpath = "//a[@id='add-organization-card-block']")
	WebElement addNewCreditCard;
	
	@FindBy(xpath = "//input[@id='card_number']")
	WebElement inputCreditCardNumber;
	
	@FindBy(xpath = "//input[@id='card_code']")
	WebElement inputCVVNumber;
	
	@FindBy(xpath = "//button[@id='add-new-organization-card']")
	WebElement buttonAddCreditCard;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement alertMessage;
	
	@FindBy(xpath = "//span[contains(text(),'MasterCard')]")
	WebElement masterCard;
	
	//@FindBy(xpath = "//a[@id='delete-organization-card']")
	@FindBy(xpath = "//span[normalize-space()='Discover']")
	WebElement deleteCard;
	
	@FindBy(xpath = "//a[@href='/my_organization/edit']")
	WebElement buttonMyOrganizationEdit;
	
	@FindBy(xpath = "//input[@id='organization_name']")
	WebElement inputOrganizationName;
	
	@FindBy(xpath = "//input[@id='organization_address1']")
	WebElement inputAddress1ofRequestor;
	
	@FindBy(xpath = "//input[@id='organization_city']")
	WebElement inputOrganizationCity;
	
	@FindBy(xpath = "//input[@id='organization_zipcode']")
	WebElement inputOrganizationZipcode;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement buttonUpdate;
	
	public void createNewRequest() {
		makeaNewRequestForRecords.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @param State    Name
	 * @param Provider Name
	 * @Description Select the State name and Provider name for making the new
	 *              request
	 */

	public void selectStateFromRequest(String State, String ProviderName) {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		selectState.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//div[@id='search_state_chosen']//ul[contains(@class,'chosen-results')]//li[contains(text(),'"
						+ State + "')]"))
				.click();
		inputProviderName.sendKeys(ProviderName);
		searchRequestorNameButton.click();
	}

	public String getAccountDetails() {
		TestUtil.hardWait(10);
		tabMyAccount.click();
		return getUserEmailId.getText();
	}

	public String getMessageText() {
		return navigationTabMessage.getText();
	}

	public int getMessageCount() {
		String value = getMessageText();
		StringBuffer tempValue = TestUtil.getOnlyNumberFromStringWithOutPattern(value);
		System.out.println("Value is " + tempValue);
		return Integer.parseInt(tempValue.toString());
	}

	public void verifyMessageCount() {
		String userName = CreateRequest.nameoFtheUser.getText();
		int value1 = getMessageCount();
		TestListener.infoMessage("Value of Message Count is:- "+value1);
		if (userName.equalsIgnoreCase("Custodian") && value1 > 0) {
			System.out.println("Message From Requestor");
			TestListener.infoMessage("Message From Requestor");
		} else {
			System.out.println("Message From Custodian");
			TestListener.infoMessage("Message From Custodian");
		}

	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the My Account Tab
	 */

	public void openMyAccountTab() {
		wait.until(ExpectedConditions.elementToBeClickable(tabMyAccount));
		TestListener.infoMessage("Click on My Account Tab");
		tabMyAccount.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the My Account Tab and then click on the Edit button
	 */

	public void clickEditButtonMyAccountTab() {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountEditButton));
		TestListener.infoMessage("Click on My Account Edit Button");
		myAccountEditButton.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Change the First Name, Middle Name, Last Name
	 * @param First  Name
	 * @param Middle Name
	 * @param Last   Name
	 */

	public void changeName(String NewFirstName, String NewMiddleName, String NewLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountEditFirstNameInput));
		if (!NewFirstName.isEmpty() || NewFirstName != null) {
			myAccountEditFirstNameInput.clear();
			myAccountEditFirstNameInput.sendKeys(NewFirstName);
			TestListener.infoMessage("Change the First Name:- "+NewFirstName);

		}
		if (!NewLastName.isEmpty() || NewLastName != null) {
			myAccountEditLastNameInput.clear();
			myAccountEditLastNameInput.sendKeys(NewLastName);
			TestListener.infoMessage("Change the Last Name:- "+NewLastName);
		}
		if (!NewMiddleName.isEmpty() || NewMiddleName != null) {
			myAccountEditMiddleNameInput.clear();
			myAccountEditMiddleNameInput.sendKeys(NewMiddleName);
			TestListener.infoMessage("Change the Middle Name:- "+NewMiddleName);
		}
		saveDetails();
		TestListener.infoMessage("Saving the Details");
		wait.until(ExpectedConditions.visibilityOf(labelForWait));
		String actualValue = driver.findElement(By.xpath("//dd[contains(text(),'" + NewFirstName + "')]")).getText();
		if (actualValue.equals(NewFirstName)) {
			System.out.println("Name Changed Successfully");
			TestListener.infoMessage("Verifying the First Name Change and Name Changed Successfully");
		} else {
			System.out.println("Name Changed Un-Successfully");
			TestListener.infoMessage("Verifying the First Name Change and Name Changed Un-Successfully");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Change the Email Id
	 * @param New Email Id
	 * 
	 */
	public String changeEmailId(String NewEmailId) {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountEditEmailIDInput));
		if (!NewEmailId.isEmpty() || NewEmailId != null) {
			myAccountEditEmailIDInput.clear();
			myAccountEditEmailIDInput.sendKeys(NewEmailId);
			TestListener.infoMessage("Enter the New Email Id:- "+NewEmailId);
		}
		saveDetails();
		wait.until(ExpectedConditions.visibilityOf(labelForWait));
		String actualValue = driver.findElement(By.xpath("//dd[contains(text(),'" + NewEmailId + "')]")).getText();
		if (actualValue.equals(NewEmailId)) {
			System.out.println("Email-ID Changed Successfully");
			TestListener.infoMessage("Email-ID Changed Successfully");
		} else {
			System.out.println("Email-ID Changed Un-Successfully");
			TestListener.infoMessage("Email-ID Changed Un-Successfully");
		}
		return actualValue;

	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Change the Password of the current User
	 * @param Old     Password
	 * @param New     Password
	 * @param Confrim New Password
	 * 
	 */
	public void changePassword(String oldPassword, String newPassword, String confrimNewPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountEditOrginalPasswordInput));
		if (!oldPassword.isEmpty() || oldPassword != null) {
			myAccountEditOrginalPasswordInput.clear();
			myAccountEditOrginalPasswordInput.sendKeys(oldPassword);
			TestListener.infoMessage("Enter The Old Password");
		}
		if (!newPassword.isEmpty() || newPassword != null) {
			myAccountEditNewPasswordInput.clear();
			myAccountEditNewPasswordInput.sendKeys(newPassword);
			TestListener.infoMessage("Enter The New Password");
		}
		if (!confrimNewPassword.isEmpty() || confrimNewPassword != null) {
			myAccountEditNewConfrimPasswordInput.clear();
			myAccountEditNewConfrimPasswordInput.sendKeys(confrimNewPassword);
			TestListener.infoMessage("Enter The Confrim New Password");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on Save Button On My Account Navigation Tab
	 * 
	 */
	public void saveDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Add new Favorite Provider
	 * @param List of Favorite Provider
	 */
	public void enterFavoriteProvider(List<String> nameFavoriteProvider) {
		wait.until(ExpectedConditions.elementToBeClickable(inputFavoriteProvider));
		inputFavoriteProvider.click();
		for (String string : nameFavoriteProvider) {
			inputFavoriteProviderValue.sendKeys(string);
			TestListener.infoMessage("Enter The Name Provider");
			inputFavoriteProviderValue.sendKeys(Keys.ENTER);
		}
		saveDetails();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Add new Date of Birth
	 * @param New date Of Birth
	 */
	public void enterNewDateOfBirth(String NewdateOfBirth) {
		wait.until(ExpectedConditions.elementToBeClickable(inputDateofBirth));
		inputDateofBirth.click();
		inputDateofBirth.sendKeys(NewdateOfBirth);
		TestListener.infoMessage("Enter The New Date of Birth "+NewdateOfBirth);
		inputDateofBirth.sendKeys(Keys.ENTER);
		saveDetails();
		String actualValue = driver.findElement(By.xpath("//dt[contains(text(),'Gender')]/preceding::dd[1]")).getText();
		String newActualValue = actualValue.replace("/", "");
		if (newActualValue.equals(NewdateOfBirth)) {
			System.out.println("Date of Birth Changed Successfully");
			TestListener.infoMessage("Date of Birth Changed Successfully");
		} else {
			System.out.println("Date of Birth Changed Un-Successfully");
			TestListener.infoMessage("Date of Birth Changed Un-Successfully");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on My Organization Tab Present on the Navigation Pane
	 */
	public void clicknavigationTabMyOrganization() {
		wait.until(ExpectedConditions.elementToBeClickable(navigationTabMyOrganization));
		navigationTabMyOrganization.click();
		TestListener.infoMessage("Navigate to My Organization");
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Fill Details in Form for the New User
	 * @param First Name
	 * @param Last Name
	 * @param Phone No
	 * @param Date of Birth
	 * @param full Name
	 * @param Initials
	 */
	
	public void addInviteYourColleagues(String FirstName, String LastName, String EmailId, String PhoneNo,
			String DateofBirth, String fullName, String Initials) {
		String oldNoOfUser = noOfUser.getText();
		TestListener.infoMessage("Getting No of Users "+oldNoOfUser);
		int oldNumber = Integer.parseInt(oldNoOfUser.replaceAll(" Users", ""));
		wait.until(ExpectedConditions.elementToBeClickable(buttonInviteYourColleagues));
		buttonInviteYourColleagues.click();
		TestListener.infoMessage("Clicked on Invite Your Colleagues");
		wait.until(ExpectedConditions.elementToBeClickable(inputInviteYourColleaguesFirstName));
		inputInviteYourColleaguesFirstName.sendKeys(FirstName);
		TestListener.infoMessage("First Name of Invite User "+FirstName);
		inputInviteYourColleaguesLastName.sendKeys(LastName);
		TestListener.infoMessage("Last Name of Invite User "+LastName);
		inputInviteYourColleaguesEmailId.sendKeys(EmailId);
		TestListener.infoMessage("Email Id of Invite User "+EmailId);
		inputInviteYourColleaguesPhoneNumber.sendKeys(PhoneNo);
		TestListener.infoMessage("Phone Number of Invite User "+PhoneNo);
		/*inputInviteYourColleaguesDateofBirth.sendKeys(DateofBirth);
		TestListener.infoMessage("Date of Birth of Invite User "+DateofBirth);
		inputInviteYourColleaguesDateofBirth.sendKeys(Keys.ENTER);*/
		if (TestUtil.isElementDisplayed(inputInviteYourColleaguesFullName)) {
			inputInviteYourColleaguesFullName.sendKeys(fullName);
			inputInviteYourColleaguesInitials.sendKeys(Initials);
			inputInviteYourColleaguesCheckbox.click();
		}
		buttonInviteYourColleaguesSendInvitation.click();
		clicknavigationTabMyOrganization();
		wait.until(ExpectedConditions.visibilityOf(noOfUser));
		String newNoOfUser = noOfUser.getText();
		int newNumber = Integer.parseInt(newNoOfUser.replaceAll(" Users", "").replaceAll(" User", ""));
		if (oldNumber < newNumber) {
			System.out.println("User Add Successfully");
			TestListener.infoMessage("User Add Successfully");
		} else if (oldNumber == newNumber) {
			System.out.println("New User adding un-Successfully");
			TestListener.infoMessage("New User adding un-Successfully");
		} else {
			System.out.println("No New User Added");
			TestListener.infoMessage("No New User Added");
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on Available Credit Cards available in the My Organization Tab
	 */
	public void clickAvailableCreditCards() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonAvailableCreditCards));
		buttonAvailableCreditCards.click();
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Add nd Delete New card
	 * @param Credit card Number
	 * @param Credit Card CvvNumber
	 * @param Credit Card Expiry Month
	 * @param Credit Card Expiry Year
	 *
	 *
	 */
	public void addAndDeleteNewCreditCard(String CCNumber, String CCVNumber, String ccMonth, String ccYear) {
		clickAvailableCreditCards();
		wait.until(ExpectedConditions.visibilityOf(buttonDropDownChooseAction));
		buttonDropDownChooseAction.click();
		wait.until(ExpectedConditions.visibilityOf(addNewCreditCard));
		addNewCreditCard.click();
		wait.until(ExpectedConditions.visibilityOf(inputCreditCardNumber));
		inputCreditCardNumber.sendKeys(CCNumber);
		TestListener.infoMessage("Credit Card No:- "+CCNumber);
		inputCVVNumber.sendKeys(CCVNumber);
		TestListener.infoMessage("Credit Card CVV No:- "+CCVNumber);
		createRequest.selectCreditCardMonth(ccMonth);
		TestListener.infoMessage("Credit Card Month:- "+ccMonth);
		createRequest.selectCreditCardYear(ccYear);
		TestListener.infoMessage("Credit Card Year:- "+ccYear);
		buttonAddCreditCard.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		masterCard.click();
		buttonDropDownChooseAction.click();
		wait.until(ExpectedConditions.visibilityOf(deleteCard));
		deleteCard.click();
		String message=alertMessage.getText();
		if (message.contains("Deleted")) {
			System.out.println("Card Delete Successfully");
			TestListener.infoMessage("Card Delete Successfully");
		} else {
			System.out.println("Card Not Delete Successfully");
			TestListener.infoMessage("Card Not Delete Successfully");
		}
		
	}
	
	public void changeOrganizationNameAddress1CityStateZipCodePhone(String OrganizationName,String Address1,String CityName,String StateName,String ZipCode) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonMyOrganizationEdit));
		buttonMyOrganizationEdit.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputOrganizationName));
		inputOrganizationName.clear();
		inputOrganizationName.sendKeys(OrganizationName);
		TestListener.infoMessage("Organization Name is :- "+OrganizationName);
		wait.until(ExpectedConditions.elementToBeClickable(inputAddress1ofRequestor));
		inputAddress1ofRequestor.clear();
		inputAddress1ofRequestor.sendKeys(Address1);
		TestListener.infoMessage("Organization Address is :- "+Address1);
		wait.until(ExpectedConditions.elementToBeClickable(inputOrganizationCity));
		inputOrganizationCity.clear();
		inputOrganizationCity.sendKeys(CityName);
		TestListener.infoMessage("Organization City Name is :- "+CityName);
		selectOrganizationState(StateName);
		TestListener.infoMessage("Organization State Name is :- "+StateName);
		wait.until(ExpectedConditions.elementToBeClickable(inputOrganizationZipcode));
		inputOrganizationZipcode.clear();
		inputOrganizationZipcode.sendKeys(ZipCode);
		TestListener.infoMessage("Organization Zip Code is :- "+ZipCode);
		wait.until(ExpectedConditions.elementToBeClickable(buttonUpdate));
		buttonUpdate.click();
		TestListener.addDynamicScreenshotInReport("changeOrganizationNameAddress1CityStateZipCodePhone");
	}
	
	public void selectOrganizationState(String StateName) {
		Select selectCityName = new Select(driver.findElement(By.name("organization[state]")));
		selectCityName.selectByVisibleText(StateName);
	}
}
