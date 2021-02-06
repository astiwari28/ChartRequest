package com.ChartRequest.Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminPermissionPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] Permissions')]")
	WebElement adminPermissionsTab;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[@href='/company/user_roles'][contains(normalize-space(),'User Roles')]")
	WebElement userRolesTab;

	@FindBy(xpath = "//a[@href='/company/user_roles/new']")
	WebElement buttonPermissionUserRolesAddUser;

	@FindBy(xpath = "//input[@id='email']")
	WebElement inputEmailId;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSave;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement alertMessage;

	@FindBy(xpath = "//a[@href='/company/role_accesses'][contains(normalize-space(),'Access Grid')]")
	WebElement accessGridTab;

	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Allow user to perform QA')]/following::input[3]")
	WebElement checkBoxAllowUserToPerfrom;

	@FindBy(xpath = "//input[@value='Save Access Grid Changes']")
	WebElement buttonSaveAccessGridChanges;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement statusMessage;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement buttonReasonForProcessing;

	@FindBy(xpath = "//div[@id='submit-qa-Modal']//p")
	WebElement textToBeVerifyAfterSubmitToQAButton;

	@FindBy(xpath = "//button[text()='Submit to QA']")
	WebElement buttonSubmitToQA;

	@FindBy(xpath = "//div[@id='submit-qa-Modal']//button[@type='button'][contains(normalize-space(),'Close')]")
	WebElement closeButtonAfterSubmitToQA;

	@FindBy(xpath = "//a[contains(normalize-space(),'Perform QA Now')]")
	WebElement buttonPerFromQANow;

	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Allow User to QA their Own Request')]/following::input[3]")
	WebElement checkBoxAllowUserToQATheirOwnRequest;

	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Override Pricing from Request Form')]/following::input[3]")
	WebElement checkBoxOverridePricingfromRequestForm;

	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Lock / unlock Request')]/following::input[3]")
	WebElement checkBoxLockAndunlockRequest;

	@FindBy(xpath = "//i[@class='fas fa-lock lock-icon-css']")
	WebElement buttonLock;
	
	@FindBy(xpath = "//i[contains(@class,'fas fa-unlock lock-unlock-icon-css')]")
	WebElement buttonUnlock;

	@FindBy(xpath = "//tbody/tr/td[contains(text(),'View All Tabs on CSA Home')]/following::input[3]")
	WebElement checkBoxViewAllTabsonCSAHome;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] CSA Home')]")
	WebElement adminCSAHomePage;
	
	@FindBy(xpath = "//h4[contains(text(),'Daily Progress Ranking')]")
	WebElement headingDailyProgressRanking;
	
	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Merge/Delete Custodians')]/following::input[3]")
	WebElement checkBoxMergeAndDeleteCustodians;
	
	@FindBy(xpath = "//button[contains(@data-toggle,'dropdown')]")
	WebElement dropDownAdmin;

	@FindBy(xpath = "//a[contains(text(),'Delete Custodian')]")
	WebElement buttonDeleteCustodian;
	
	@FindBy(xpath = "//tbody/tr/td[contains(text(),'View/Edit Permissions')]/following::input[3]")
	WebElement checkBoxViewAndEditPermissions;
	
	@FindBy(xpath = "//tbody/tr/td[contains(text(),'View audit log in requests')]/following::input[3]")
	WebElement checkBoxViewAuditLogInRequests ;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] View audit log')]")
	WebElement linkVerifyViewAuditLog;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] Requestor View')]")
	WebElement linkRequestorView;
	
	@FindBy(xpath = "//input[@id='user-email']")
	WebElement inputUserEmailUserRole;
	
	@FindBy(xpath = "//a[contains(text(),'Remove Role')]")
	WebElement buttonRemoveRole;
	
	@FindBy(xpath = "//a[contains(@data-toggle,'dropdown')]")
	WebElement dropDownUserName;
	
	@FindBy(xpath = "//a[@href='/company/retrieval_dashboards']")
	WebElement buttonAdminRetrievalDashboard;
	
	@FindBy(xpath = "//input[@id='user-email']")
	WebElement inputEmailIdForRole;
	
	@FindBy(xpath = "//input[@id='user-submit']")
	WebElement buttonSearchForRole;
	
	@FindBy(xpath = "//h5[normalize-space()='No Matching Records Found.']")
	WebElement headingNoRecordsFound;
	
	@FindBy(xpath = "//td/input[@id='view_edit_retrieval_dashboard_' and @value='retrieval_specialist' ]")
	WebElement checkboxViewEditRetrievalDashboard;	
	
	public AdminPermissionPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Permission Page from the admin page
	 */
	public void openPermissionPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminPermissionsTab));
		adminPermissionsTab.click();
		TestListener.infoMessage("Opening of Admin Permission Page");
		wait.until(ExpectedConditions.visibilityOf(userRolesTab));
	}

	public void addUser(String emailId, String Role) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonPermissionUserRolesAddUser));
		buttonPermissionUserRolesAddUser.click();
		wait.until(ExpectedConditions.visibilityOf(inputEmailId));
		inputEmailId.sendKeys(emailId);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
		buttonSearch.click();
		selectEmail(emailId);
		selectRole(Role);
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actualMessage = alertMessage.getText();
		if (actualMessage.contains("User Role " + Role + " has created successfully.")) {
			System.out.println("User Added Successfully");
			TestListener.infoMessage("User Added Successfully having Role is "+Role);
		} else {
			System.out.println("User NOT Added Successfully");
			TestListener.infoMessageFail("User NOT Added Successfully");
		}
	}

	public void selectEmail(String Email) {
		Select selectState = new Select(driver.findElement(By.name("user[user_id]")));
		selectState.selectByVisibleText(Email);
	}

	public void selectRole(String Role) {
		Select selectState = new Select(driver.findElement(By.name("user[role]")));
		selectState.selectByVisibleText(Role);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Permission Page and swtich to access Grid page from the
	 *              admin page
	 */
	public void openPermissionAndSwtichToAccessGridPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminPermissionsTab));
		adminPermissionsTab.click();
		TestListener.infoMessage("Opening of Access Grid Tab");
		wait.until(ExpectedConditions.visibilityOf(accessGridTab));
		accessGridTab.click();
	}

	public boolean changePermissionAllowUserToPerformQA() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxAllowUserToPerfrom));
		checkBoxAllowUserToPerfrom.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission FOr Allow User To Perform QA");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxAllowUserToPerfrom.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);

		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}

	public void processingTheReasonforAccessingRequest() {
		wait.until(ExpectedConditions.visibilityOf(buttonReasonForProcessing));
		buttonReasonForProcessing.click();
	}

	public void verifyPerformQANowButton(boolean statusOfCheckBox) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitToQA));
		if (TestUtil.isElementDisplayed(buttonSubmitToQA)) {
			buttonSubmitToQA.click();
			wait.until(ExpectedConditions.visibilityOf(closeButtonAfterSubmitToQA));
			if (TestUtil.isElementDisplayed(buttonPerFromQANow)) {
				System.out.println("Button is Present and Status of Checkbox is :-> " + statusOfCheckBox);
				TestListener.infoMessage("Button is Present and Status of Checkbox is :-> " + statusOfCheckBox);
			} else {
				System.out.println("Button is Not-Present and Status of Checkbox is :-> " + statusOfCheckBox);
				TestListener.infoMessage("Button is Not-Present and Status of Checkbox is :-> " + statusOfCheckBox);
			}
		} else {
			System.out.println("Submit To QA button is present");
		}
	}

	public boolean changePermissionAllowUserToQATheirOwnRequest() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxAllowUserToQATheirOwnRequest));
		checkBoxAllowUserToQATheirOwnRequest.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For Allow User To QA Their Own Request");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxAllowUserToQATheirOwnRequest.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}

	public void verifyAllowUserToQATheirOwnRequest(boolean statusOfCheckBox) {
		System.out.println("Need Calrification With Jafar how to Perform this action");
	}

	public boolean changePermissionOverridePricingfromRequestForm() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxOverridePricingfromRequestForm));
		checkBoxOverridePricingfromRequestForm.click();
		buttonSaveAccessGridChanges.click();
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxOverridePricingfromRequestForm.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}

	public void verifyPerformOverridePricingfromRequestForm(boolean statusOfCheckBox) {
		wait.until(ExpectedConditions.visibilityOf(checkBoxOverridePricingfromRequestForm));
	}

	public boolean changePermissionlockAndUnlockRequest() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxLockAndunlockRequest));
		checkBoxLockAndunlockRequest.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For lock And Unlock Request");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxLockAndunlockRequest.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}

	public void verifyLockAndUnlockRequest(boolean statusOfCheckBox) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitToQA));
		if (TestUtil.isClickable(buttonLock)) {
			//buttonLock.click();
			System.out.println("Lock Button is Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Lock Button is Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
		} else {
			System.out.println("Lock Button is Not Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Lock Button is Not Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
		}
	}

	public boolean changePermissionViewAllTabsonCSAHome() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxViewAllTabsonCSAHome));
		checkBoxViewAllTabsonCSAHome.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For View All Tabs on CSAHome");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxViewAllTabsonCSAHome.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}

	public void verifyCSAHomePage(boolean statusOfCheckBox) {
		List<String> tabNames = new ArrayList<String>();
		System.out.println("Opening the Custodian Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminPermissionsTab));
		adminCSAHomePage.click();
		TestListener.infoMessage("Opening of Admin CSA Home Page");
		wait.until(ExpectedConditions.visibilityOf(headingDailyProgressRanking));
		int noOfTabs=driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li")).size();
		if (noOfTabs>4) {
			System.out.println("CSA Home Page Showing All Tabs and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("CSA Home Page Showing All Tabs and Status of Checkbox is :-> " + statusOfCheckBox);
		} else {
			System.out.println("CSA Home Page Not Showing All Tabs and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("CSA Home Page Not Showing All Tabs and Status of Checkbox is :-> " + statusOfCheckBox);
		}
		for (int i = 1; i <=noOfTabs; i++) {
			String tabName=driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li["+i+"]")).getText();
			tabNames.add(tabName);
		}
		System.out.println("Names of Tabs Are:- "+tabNames);
		TestListener.infoMessage("Names of Tabs Are:- "+tabNames);
	}
	
	public boolean changePermissionMergeAndDeleteRequestors() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxMergeAndDeleteCustodians));
		checkBoxMergeAndDeleteCustodians.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For Merge And Delete Requestors");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxMergeAndDeleteCustodians.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}
	
	public void verifyMergeAndDeleteCustion(boolean statusOfCheckBox) {
		TestUtil.hardWait(5);
		dropDownAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownAdmin));
		if (TestUtil.isClickable(buttonDeleteCustodian)) {
			System.out.println("Custodian Admin Drop Down is Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Custodian Admin Drop Down is Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
		} else {
			System.out.println("Custodian Admin Drop Down is Not Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Custodian Admin Drop Down is Not Clickable and Status of Checkbox is :-> " + statusOfCheckBox);
		}
	}
	
	public boolean changePermissionViewAndEditPermission() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxViewAndEditPermissions));
		checkBoxViewAndEditPermissions.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For View And Edit Permission");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxViewAndEditPermissions.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}
	
	public void verifyViewAndEditPermission(boolean statusOfCheckBox) {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		if (TestUtil.isElementDisplayed(adminPermissionsTab)) {
			System.out.println("Custodian Admin Permission Tab is Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Custodian Admin Permission Tab is Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
		} else {
			System.out.println("Custodian Admin Permission Tab is NOT Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("Custodian Admin Permission Tab is NOT Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
		}
	}
	
	public boolean changePermissionViewAuditLogInRequests() {
		boolean statusOfCheckBox, flag;
		wait.until(ExpectedConditions.visibilityOf(checkBoxViewAuditLogInRequests));
		checkBoxViewAuditLogInRequests.click();
		buttonSaveAccessGridChanges.click();
		TestListener.infoMessage("Change Permission For View Audit Log In Requests");
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		statusOfCheckBox = checkBoxViewAuditLogInRequests.isSelected();
		if (statusOfCheckBox) {
			flag = true;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		} else {
			flag = false;
			System.out.println("Status of Checkbox is " + statusOfCheckBox);
			TestListener.infoMessage("Status of Checkbox is " + statusOfCheckBox);
		}
		return flag;
	}
	
	public void verifyViewAuditLogInRequests(boolean statusOfCheckBox) {
		processingTheReasonforAccessingRequest();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(linkRequestorView));
		linkRequestorView.click();
		TestUtil.hardWait(10);
		if (TestUtil.isElementDisplayed(linkVerifyViewAuditLog)) {
			System.out.println("View Audit Log is Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("View Audit Log is Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
		} else {
			System.out.println("View Audit Log is NOT Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
			TestListener.infoMessage("View Audit Log is NOT Clickable/Visible and Status of Checkbox is :-> " + statusOfCheckBox);
		}
	}
	
	public void removeUserRole(String emailIdToBeRemove) {
		wait.until(ExpectedConditions.visibilityOf(inputUserEmailUserRole));
		inputUserEmailUserRole.sendKeys(emailIdToBeRemove);
		TestListener.infoMessage("Remove User from there Role " + emailIdToBeRemove);
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(buttonRemoveRole));
		buttonRemoveRole.click();
		TestListener.infoMessage("User removed Sucessfull " + emailIdToBeRemove);
	}
	
	public void verifyRetrievalSpecialist() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownUserName));
		dropDownUserName.click();
		if (TestUtil.isElementDisplayed(buttonAdminRetrievalDashboard)) {
			TestUtil.hardWait(5);
			buttonAdminRetrievalDashboard.click();
			System.out.println("Its is a Retrieval Specialist");
		} else {
			System.out.println("Its is NOT a Retrieval Specialist");
		}
	}
	
	/*public boolean verifyUserRoleExisiting(String emailId) {
		wait.until(ExpectedConditions.elementToBeClickable(inputEmailIdForRole));
		inputEmailIdForRole.sendKeys(emailId);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearchForRole));
		buttonSearchForRole.click();
		boolean flag=false;
		//String tempHeading=headingNoRecordsFound.getText();
		//System.out.println("Temp Heading: "+tempHeading);
		if (TestUtil.isElementDisplayed(driver.findElement(By.xpath("//td[normalize-space()='"+emailId+"']")))) {
		//if(!tempHeading.contains("No Matching Records Found")) {	
		System.out.println("Role Already Existing");
			flag=true;
		}
		else if(TestUtil.isElementDisplayed(driver.findElement(By.xpath("//h5[normalize-space()='No Matching Records Found.']")))) {
			flag=false;
		}
		else {
			System.out.println("Role Not Existing");
			flag=false;
		}
		return flag;
	}*/
	
	public boolean verifyUserRoleExisiting(String emailId) {
		wait.until(ExpectedConditions.elementToBeClickable(inputEmailIdForRole));
		inputEmailIdForRole.sendKeys(emailId);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearchForRole));
		buttonSearchForRole.click();
		boolean flag = false;
		// String tempHeading=headingNoRecordsFound.getText();
		// System.out.println("Temp Heading: "+tempHeading);
		// if
		// (TestUtil.isElementDisplayed(driver.findElement(By.xpath("//td[normalize-space()='"+emailId+"']"))))
		// {
		if (TestUtil.isElementDisplayed(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")))) {
			if (TestUtil.isElementDisplayed(driver.findElement(By.xpath("//h5[normalize-space()='No Matching Records Found.']")))) {
				flag = false;
			} else {
				System.out.println("Role Already Existing");
				flag = true;
			}
		} else {
			System.out.println("Role Not Existing");
			flag = false;
		}
		return flag;
	}
	
	public boolean verifyFromAccessGrid() {
		boolean flag;
		wait.until(ExpectedConditions.elementToBeClickable(accessGridTab));
		accessGridTab.click();
		boolean status=checkboxViewEditRetrievalDashboard.isSelected();
		TestUtil.scrollToElement(checkboxViewEditRetrievalDashboard);
		if (status) {
			flag=true;
		} else {
			flag=false;
		}
		return flag;
	}
	
	public void ViewEditRetrievalDashboardCheck() {
		wait.until(ExpectedConditions.elementToBeClickable(checkboxViewEditRetrievalDashboard));
		checkboxViewEditRetrievalDashboard.click();
	}
}
