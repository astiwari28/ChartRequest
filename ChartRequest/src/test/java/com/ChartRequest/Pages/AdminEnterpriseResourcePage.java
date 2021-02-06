package com.ChartRequest.Pages;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Exp;
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

public class AdminEnterpriseResourcePage extends BrowserConfiguration{

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//li//a[contains(text(),'[adm] Enterprise Resources')]")
	WebElement adminDropDownAdminEnterpriseResources;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Multi-Location Landing Page')]")
	WebElement adminMultiLoactionLandingPageTab;
	
	@FindBy(xpath = "//a[@class='btn btn-large btn-success pull-right add_multi_location_page']")
	WebElement buttonCreateNewLandingPage;
	
	@FindBy(xpath = "//p[contains(text(),'Create a customized URL')]")
	WebElement headingForWait;
	
	@FindBy(xpath = "//input[@id='multi_location_landing_page_page_url']")
	WebElement inputCustosmURL;
	
	@FindBy(xpath = "//input[@id='multi_location_landing_page_page_logo']")
	WebElement buttonUploadLogo;
	
	@FindBy(xpath = "//button[@id='create-page']")
	WebElement buttonCreateLandingURL;
	
	@FindBy(xpath = "//a[contains(@class,'btn modal-popup preview-page')]")
	WebElement buttonPreview;
	
	@FindBy(xpath = "//a[contains(@class,'btn modal-popup preview-page')]")
	WebElement previewPage;
	
	@FindBy(xpath = "//button[@data-dismiss='modal']")
	WebElement buttonClosePreview;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement messageStatus;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'SIGN UP')]")
	WebElement newWebPageSingupLink;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Enterprise Admin')]")
	WebElement adminEnterpriseAdminTab;
	
	@FindBy(xpath = "//a[@href='#newEnterpriseAdminModal']")
	WebElement buttonAddNewEnterprisesAdmin;
	
	@FindBy(xpath = "//input[@id='enterprise_admin_enterprise_admin_name']")
	WebElement inputEnterpriseAdminName;
	
	@FindBy(xpath = "//input[@value='Select Custodian']")
	WebElement inputSelectCustodian;
	
	@FindBy(xpath = "//button[@id='new_enterprise_admin_btn']")
	WebElement buttonSaveButton;
	
	@FindBy(xpath = "//input[@id='enterpriseadmin_name']")
	WebElement inputSearchEnterpriseAdminName;
	
	@FindBy(xpath = "//button[contains(normalize-space(),'Search')]")
	WebElement buttonSearchAdminEnterprise;
	
	//@FindBy(xpath = "//tr[@class='row-enterprise-admin']")
	@FindBy(xpath = "//p[@class='epa-name']")
	WebElement searchResultAdminEnterprise;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-edit open-edit-mode']")
	WebElement editSearchedNewAdminEnterprise;
	
	@FindBy(xpath = "//span[@class='btn btn-danger remove-epa']")
	WebElement buttonDeleteEnterpriseAdmin;
	
	@FindBy(xpath = "//button[contains(normalize-space(),'OK')]")
	WebElement buttonFinalDeleteEntireEnterpriseAdminPage;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'SSO Permission')]")
	WebElement adminSSOPermissionTab;
	
	@FindBy(xpath = "//a[@href='#addUserModal']")
	WebElement buttonAddUserSSOPermission;
	
	@FindBy(xpath = "//div[@id='user_for_association_chosen']//span")
	WebElement dropDownSelectUser;
	
	@FindBy(xpath = "//div[@id='user_for_association_chosen']//input[@type='text']")
	WebElement inputSelectUserSSOPermission;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSave;
	
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement inputSearchEmailIDSSOPermission;
	
	@FindBy(xpath = "//button[contains(normalize-space(),'Search')]")
	WebElement buttonSearchSSOPermission;
	
	@FindBy(xpath = "//a[@class='btn btn-danger pull-right']")
	WebElement buttonRemoveUser;
	
	@FindBy(xpath = "//a[@href='/company/enterprise']")
	WebElement adminEnterpriseTab;
	
	@FindBy(xpath = "//a[@class='pull-right btn btn-success']")
	WebElement buttonCreateEnterpriseTabEnterprise;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement inputEnterpriseName;
	
	@FindBy(xpath = "//input[@id='organization_address']")
	WebElement inputOrganizationAddressLine1;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement inputEnterprisePhoneNumber;
	
	@FindBy(xpath = "//input[@id='organization_city']")
	WebElement inputEnterpriseOrganizationCity;
	
	@FindBy(xpath = "//input[@id='organization_zipcode']")
	WebElement inputEnterpriseZipCode;
	
	@FindBy(xpath = "//input[@value='Add Enterprise']")
	WebElement buttonEnterpriseAddEnterprise;
	
	@FindBy(xpath = "//*[contains(text(),'Automation Testing')]/following::i[@data-original-title='Go to Enterprise Settings'][1]")
	WebElement buttonEditSetting;
	
	@FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
	WebElement adminDropDownRemoveEnterprise;
	
	@FindBy(xpath = "//a[@class='modal-popup']")
	WebElement adminEnterpriseDeleteEnterprise;
	
	@FindBy(xpath = "//a[@class='btn btn-default pull-right']")
	WebElement buttonOKDeleteEnterprise;
	
	@FindBy(xpath = "//*[@id='page_url' and @value='Automation']")
	WebElement inputNewURLAfterAdd;
	
	@FindBy(xpath = "//a[contains(text(),'Routes')]")
	WebElement adminRoutesTab;
	
	@FindBy(xpath = "//a[contains(text(),'Create Route')]")
	WebElement buttonCreateRoute;
	
	@FindBy(xpath = "//input[@id='custodian_route_name']")
	WebElement inputRouteName;
	
	@FindBy(xpath = "//span[normalize-space()='AutomationTesting']/following::td[@class='mllp-show']/a[@page_url='AutomationTesting']")
	WebElement gearIconEdit;
	
	@FindBy(xpath = "//a[normalize-space()='Delete Landing Page']")
	WebElement buttonDeleteLandingPage;
	
	@FindBy(xpath = "//div[@id='organization_id_chosen']//span")
	WebElement dropDownSelectCustodianName;
	
	@FindBy(xpath = "//div[@id='organization_id_chosen']//input[@type='text']")
	WebElement inputCustodianName;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement buttonAddCustodian;
	
	@FindBy(xpath = "//a[normalize-space()='Remove']")
	WebElement buttonRemoveCustodian;
	
	@FindBy(xpath = "//button[normalize-space()='Close']")
	WebElement buttonCloseAddCustodianWindow;
	
	@FindBy(xpath = "//input[@value='Select max 2 options']")
	WebElement inputRequestDetailsType;
	
	@FindBy(xpath = "//input[@placeholder='Ex. Jane Doe']")
	WebElement inputPatientName;
	
	@FindBy(xpath = "//input[@value='Save Route']")
	WebElement buttonSaveRoute;
	
	@FindBy(xpath = "//a[normalize-space()='View Routed Requests']")
	WebElement buttonViewRoutedRequests;
	
	@FindBy(xpath = "//span[contains(text(),'New Admin Automation')]/ancestor::p[@class='epa-name']/ancestor::td/span[@class='glyphicon glyphicon-edit open-edit-mode']")
	WebElement editIconAdminEnterprise;
	
	@FindBy(xpath = "//a[@href='#enterpriseAdminAccountContact']")
	WebElement editAddNewAccount;
	
	@FindBy(xpath = "//h3[contains(text(),'Add Account Contact')]")
	WebElement headingAddNewAccountContact;
	
	@FindBy(xpath = "//input[@id='account_contacts_name']")
	WebElement inputAccountContactName;
	
	@FindBy(xpath = "//input[@id='account_contacts_email']")
	WebElement inputAccountContactEmail;
	
	@FindBy(xpath = "//input[@id='account_contacts_phone']")
	WebElement inputAccountContactPhone;
	
	@FindBy(xpath = "//button[@id='epa-account-contact-save-btn']")
	WebElement buttonAdminEnterpriseSave;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement buttonAdminEnterpriseClose;
	
	@FindBy(xpath = "//input[@value='Select Some Options']")
	WebElement inputUserNameAdminEnterprise;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign editable add_epa_user']")
	WebElement buttonAdduser;
	
	@FindBy(xpath = "//a[contains(text(),'Automation Testing Name')]/following::p[@class='col-sm-2 remove-account-contact remove-padding']")
	WebElement buttonRemoveUserAdminEnterprise;
	
	@FindBy(xpath = "//div[@class='bootbox-body']")
	WebElement headingDeleteAccountContact;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement buttonOKDeleteAccountContact;
	
	@FindBy(xpath = "//a[@data-name='Automation Testing']//i[@class='fas fa-plus-square tipsy']")
	WebElement buttonAddOrganization;
	
	@FindBy(xpath = "//div[@id='add_custodians_to_corporate']//input[@id='children_name_id_address']")
	WebElement inputSearchData;
	
	@FindBy(xpath = "//input[@id='search_non_corporate_children']")
	WebElement buttonSearchAddOrganzation;
	
	@FindBy(xpath = "//div[@class='row-fluid add_children_to_corporate']/table/thead/tr/th/input[@id='select_all_children_checkboxes']")
	WebElement checkboxSelectCustodian;
	
	@FindBy(xpath = "//button[normalize-space()='Add Selected']")
	WebElement buttonAddSelectedCustodian;
	
	@FindBy(xpath = "//a[@data-name='Automation Testing']//i[@class='fas fa-minus-square tipsy']")
	WebElement buttonRemoveSelectedCustodian;
	
	@FindBy(xpath = "//button[normalize-space()='Remove Selected']")
	WebElement buttonRemoveSelected;
	
	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement buttonConfrimRemoveOrganization;
	
	@FindBy(xpath = "//div[@class='row-fluid remove_children_from_corporate']//table[@class='main-table table-striped table-condensed']//thead[@class='border_css']//tr//th//input[@id='select_all_children_checkboxes']")
	WebElement checkboxSelectCustodianRemove;
	
	@FindBy(xpath = "//span[contains(text(),'Automation Testing')]")
	WebElement headingAutomationTesting;
	
	public AdminEnterpriseResourcePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void openAdminEnterpriseResourcesPage() {
		try {
			System.out.println("Opening the Admin Drop Down");
			TestListener.infoMessage("Opening the Admin Drop Down");
			wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
			adminDropDown.click();
			wait.until(ExpectedConditions.elementToBeClickable(adminDropDownAdminEnterpriseResources));
			adminDropDownAdminEnterpriseResources.click();
			System.out.println("Open Admin Enterprise Resources Page");
			TestListener.infoMessage("Open Admin Enterprise Resources Page");
			TestListener.addDynamicScreenshotInReport("OpeningEnterpriseResourcePage");
			wait.until(ExpectedConditions.visibilityOf(adminMultiLoactionLandingPageTab));
		} catch (Exception e) {
			TestListener.infoMessageFail("Unable to Open Admin Enterprise Page "+e.getStackTrace());
			TestListener.addDynamicScreenshotInReport("OpeningEnterpriseResourcePage");
			e.printStackTrace();
		}
	}
	
	public void createNewLandingPageURL(String templateName) {
		String tempURL = null;
		try {
			adminMultiLoactionLandingPageTab.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonCreateNewLandingPage));
			buttonCreateNewLandingPage.click();
			wait.until(ExpectedConditions.visibilityOf(headingForWait));
			inputCustosmURL.sendKeys("Automation");
			Actions actions = new Actions(driver);
			actions.moveToElement(buttonUploadLogo);
			actions.click().build().perform();
			TestUtil.hardWait(5);
			TestListener.infoMessage("Enter the URL");
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/UploadLogo.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
			selectDesignTemplate(templateName);
			buttonPreview.click();
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.visibilityOf(previewPage));
			String gettingHeadingText=previewPage.getText();
			if (gettingHeadingText.contains("Landing Page Preview")) {
				System.out.println("Preview Page is Available");
				TestUtil.hardWait(3);
				TestUtil.screenshot();
				TestListener.addDynamicScreenshotInReport("PreviewPageScreenshot");
			} else {
				System.out.println("Preview Page Not is Available");
				TestListener.addDynamicScreenshotInReport("PreviewPageScreenshot");
				TestUtil.screenshot();
			}
			buttonClosePreview.click();
			wait.until(ExpectedConditions.visibilityOf(buttonCreateLandingURL));
			buttonCreateLandingURL.click();
			wait.until(ExpectedConditions.visibilityOf(messageStatus));
		} catch (Exception e) {
			TestListener.infoMessageFail("Unable to Add New Landing Page URL "+e.getStackTrace());
			TestListener.addDynamicScreenshotInReport("OpeningEnterpriseResourcePage");
			Assert.assertFalse(false,"Unable to Add New Landing Page URL");
			e.printStackTrace();
		}
	}
	
	public void selectDesignTemplate(String TemplateName) {
		Select select = new Select(driver.findElement(By.name("multi_location_landing_page[template_type]")));
		select.selectByVisibleText(TemplateName);
	}
	
	public void verifyNewLandingUrl(String url,String newURL) {
		TestUtil.openNewTabWithURL(url+"m/"+newURL);
		wait.until(ExpectedConditions.visibilityOf(newWebPageSingupLink));
	}
	
	public boolean enterprisesAdminTab() {
		boolean flag=false;
		try {
			adminEnterpriseAdminTab.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonAddNewEnterprisesAdmin));
			if (verifyNewEnterpriseAdminAdd()) {
				System.out.println("No Need To Add");
				TestListener.infoMessage("No Need To Add");
				TestListener.addDynamicScreenshotInReport("noneedtoadd");
				flag=false;
			} else {
			buttonAddNewEnterprisesAdmin.click();
			TestListener.infoMessage("Adding New Enterpise Name");
			wait.until(ExpectedConditions.elementToBeClickable(inputEnterpriseAdminName));
			inputEnterpriseAdminName.sendKeys("New Admin Automation");
			wait.until(ExpectedConditions.visibilityOf(inputSelectCustodian));
			inputSelectCustodian.click();
			inputSelectCustodian.sendKeys("Automation Custodian");
			inputSelectCustodian.sendKeys(Keys.ENTER);
			buttonSaveButton.click();
			wait.until(ExpectedConditions.visibilityOf(messageStatus));
			System.out.println("Admin Enterprise is Created");
			TestListener.infoMessage("Admin Enterprise is Created");
			TestListener.addDynamicScreenshotInReport("AddNewEnterprise");
			flag=true;
			}
		} catch (Exception e) {
			TestListener.infoMessageFail("Unable to Add New Enterprise Admin "+e.getStackTrace());
			TestListener.addDynamicScreenshotInReport("AddNewEnterpriseAdmin");
			Assert.assertFalse(false,"Unable to add new enterprises Admin");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean verifyNewEnterpriseAdminAdd() {
		boolean flag=false;
		wait.until(ExpectedConditions.visibilityOf(inputSearchEnterpriseAdminName));
		inputSearchEnterpriseAdminName.sendKeys("New Admin Automation");
		System.out.println("Verifying the New Admin Enterprises is created");
		TestListener.infoMessage("Verifying the New Admin Enterprises is created");
		TestUtil.hardWait(5);
		TestListener.addDynamicScreenshotInReport("NewAdminAutomation");
		buttonSearchAdminEnterprise.click();
		TestUtil.hardWait(5);
		//wait.until(ExpectedConditions.visibilityOf(searchResultAdminEnterprise));
		if (TestUtil.isElementDisplayed(searchResultAdminEnterprise)) {
			System.out.println("Verified the New Admin Enterprises is created");
			TestListener.infoMessage("Verified the New Admin Enterprises is created");
			flag=true;
		} else {
			 flag=false;
		}
		return flag;
	}
	
	public void deleteNewlyAddedEnterpriseAdmin() {
		/*verifyNewEnterpriseAdminAdd();
		wait.until(ExpectedConditions.elementToBeClickable(editIconAdminEnterprise));
		editIconAdminEnterprise.click();
		//wait.until(ExpectedConditions.visibilityOf(editSearchedNewAdminEnterprise));
		TestUtil.hardWait(5);
		//editSearchedNewAdminEnterprise.click();*/
		wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteEnterpriseAdmin));
		buttonDeleteEnterpriseAdmin.click();
		TestListener.addDynamicScreenshotInReport("DeleteEnterpriseAdmin");
		wait.until(ExpectedConditions.elementToBeClickable(buttonFinalDeleteEntireEnterpriseAdminPage));
		buttonFinalDeleteEntireEnterpriseAdminPage.click();
	}
	
	public void addUserSSOPermission() {
		wait.until(ExpectedConditions.visibilityOf(adminSSOPermissionTab));
		adminSSOPermissionTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddUserSSOPermission));
		buttonAddUserSSOPermission.click();
		TestListener.addDynamicScreenshotInReport("addUserSSOPermission");
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectUser));
		dropDownSelectUser.click();
		String tempURL=driver.getCurrentUrl();
		if (tempURL.contains("preproduction")) {
			inputSelectUserSSOPermission.sendKeys("Custodian Automation");
			inputSelectUserSSOPermission.sendKeys(Keys.ENTER);

		} else {
			inputSelectUserSSOPermission.sendKeys(GlobalVariables.newCustodian);
			inputSelectUserSSOPermission.sendKeys(Keys.ENTER);
		}
		buttonSave.click();
	}
	
	public void removeUserSSOPermission() {
		wait.until(ExpectedConditions.elementToBeClickable(inputSearchEmailIDSSOPermission));
		String tempURL=driver.getCurrentUrl();
		if (tempURL.contains("preproduction")) {
			inputSearchEmailIDSSOPermission.sendKeys("custodian.automation@test.com");
			buttonSearchSSOPermission.click();
		} else {
			inputSearchEmailIDSSOPermission.sendKeys(GlobalVariables.newCustodian);
			buttonSearchSSOPermission.click();
		}

		TestListener.addDynamicScreenshotInReport("searchSSOPermission");
		wait.until(ExpectedConditions.elementToBeClickable(buttonRemoveUser));
		buttonRemoveUser.click();
		driver.switchTo().alert().accept();
		TestListener.addDynamicScreenshotInReport("UserSSOPermission");
	}
	
	public void addCreateEnterprise(String EnterpriseType,String OrganizationType) {
		wait.until(ExpectedConditions.visibilityOf(adminEnterpriseTab));
		adminEnterpriseTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonCreateEnterpriseTabEnterprise));
		buttonCreateEnterpriseTabEnterprise.click();
		wait.until(ExpectedConditions.visibilityOf(inputEnterpriseName));
		inputEnterpriseName.sendKeys("Automation Testing");
		selectEnterpriseType(EnterpriseType);
		selectYourOrganizationType(OrganizationType);
		inputOrganizationAddressLine1.sendKeys(GlobalVariables.GlobalAddress);
		inputEnterprisePhoneNumber.sendKeys("1234567890");
		inputEnterpriseOrganizationCity.sendKeys(GlobalVariables.GlobalCityName);
		selectYourOrganzationState(GlobalVariables.GlobalStateName);
		inputEnterpriseZipCode.sendKeys(GlobalVariables.GlobalZipCode);
		buttonEnterpriseAddEnterprise.click();
		wait.until(ExpectedConditions.visibilityOf(messageStatus));
		String tempMessage=messageStatus.getText();
		if (tempMessage.contains("Enterprise Created Successfully")) {
			System.out.println("Enterprise Create Successfully");
			TestListener.addDynamicScreenshotInReport("EnterpriseCreateSuccessfully");
			TestListener.infoMessage("Enterprise Create Successfully");
		} else {
			TestListener.addDynamicScreenshotInReport("EnterpriseCreateSuccessfully");
			TestListener.infoMessageFail("Enterprise Create UN-Successfully");
		}
		TestUtil.hardWait(5);
	}	
	
	public void selectEnterpriseType(String EnterpriseType) {
		Select select = new Select(driver.findElement(By.name("organization_type")));
		select.selectByVisibleText(EnterpriseType);
	}
	
	public void selectYourOrganizationType(String OrganizationType) {
		Select select = new Select(driver.findElement(By.name("service_level_cust")));
		select.selectByVisibleText(OrganizationType);
	}
	
	public void selectYourOrganzationState(String OrganizationState) {
		Select select = new Select(driver.findElement(By.name("organization_state")));
		select.selectByVisibleText(OrganizationState);
	}
	
	public void addOrganizationEnterprise() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddOrganization));
		buttonAddOrganization.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputSearchData));
		inputSearchData.click();
		inputSearchData.sendKeys("Automation Custodian");
		buttonSearchAddOrganzation.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkboxSelectCustodian));
		checkboxSelectCustodian.click();
		buttonAddSelectedCustodian.click();
		TestUtil.hardWait(5);
	}
	
	public void removeOrganizationEnterprise() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(buttonRemoveSelectedCustodian));
		buttonRemoveSelectedCustodian.click();;
		wait.until(ExpectedConditions.elementToBeClickable(checkboxSelectCustodianRemove));
		checkboxSelectCustodianRemove.click();
		buttonRemoveSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonConfrimRemoveOrganization));
		buttonConfrimRemoveOrganization.click();
		TestUtil.hardWait(5);
	}
	
	public void removeEnterpriseAdd() {
		wait.until(ExpectedConditions.visibilityOf(buttonEditSetting));
		buttonEditSetting.click();
		TestUtil.swtichTab(1);
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownRemoveEnterprise));
		adminDropDownRemoveEnterprise.click();
		wait.until(ExpectedConditions.visibilityOf(adminEnterpriseDeleteEnterprise));
		adminEnterpriseDeleteEnterprise.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonOKDeleteEnterprise));
		TestListener.addDynamicScreenshotInReport("buttonOKDeleteEnterprise");
		buttonOKDeleteEnterprise.click();
		wait.until(ExpectedConditions.visibilityOf(messageStatus));
		TestListener.addDynamicScreenshotInReport("deleteEnterprise");
	}
	
	public void changeMultiLocationLandingPageURL() {
		driver.findElement(By.xpath("//span[normalize-space()='Automation']/ancestor::td/a[@class='open-edit-mode-mllp']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Automation')]/following::p/input[@id='page_url']")).clear();
		inputNewURLAfterAdd.sendKeys("AutomationTesting");
		System.out.println("Changed the URL");
		TestListener.infoMessage("Changed The URL");
		TestListener.addDynamicScreenshotInReport("ChangeURL");
		driver.findElement(By.xpath("//span[normalize-space()='Automation']/following::td[@class='editable-mllp' and not(@style='display: none;')]/span[@class='btn btn-primary save-mllp mt10']")).click();
	}
	
	public void createRoute(String EnterpriseName, String destinationCustodianName) {
		adminRoutesTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonCreateRoute));
		buttonCreateRoute.click();
		wait.until(ExpectedConditions.visibilityOf(inputRouteName));
		String tempRouteName=TestUtil.getAlphaDynamicString(6);
		inputRouteName.sendKeys(tempRouteName);
		String verifyURL=driver.getCurrentUrl();
		if (verifyURL.contains("preproduction")) {
			selectCustodianRouteEnterpriseName("Fortis Helathcare");
		} else {
			selectCustodianRouteEnterpriseName(EnterpriseName);
		}
		inputRequestDetailsType.click();
		inputRequestDetailsType.sendKeys("Patient Name");
		inputRequestDetailsType.sendKeys(Keys.ENTER);
		inputPatientName.sendKeys("Jafar");
		if (verifyURL.contains("preproduction")) {
			selectDestinationCustodian("admin+csa");
		} else {
			selectDestinationCustodian(destinationCustodianName);
		}
		
		
		buttonSaveRoute.click();
	}
	
	public void selectCustodianRouteEnterpriseName(String EnterpriseName) {
		Select select = new Select(driver.findElement(By.name("custodian_route[enterprise_id]")));
		select.selectByVisibleText(EnterpriseName);
	}
	
	public void verifyRoute() {
		adminRoutesTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonCreateRoute));
		buttonViewRoutedRequests.click();
	}
	
	public void deletePageURL() {
		wait.until(ExpectedConditions.visibilityOf(buttonDeleteLandingPage));
		buttonDeleteLandingPage.click();
		TestUtil.hardWait(3);
		System.out.println("Delete the Landing Page URL");
		TestListener.infoMessage("Delete the Landing Page URL");
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
//		wait.until(ExpectedConditions.elementToBeClickable(buttonCloseAddCustodianWindow));
//		buttonCloseAddCustodianWindow.click();
		TestUtil.hardWait(5);
		System.out.println("Page is Deleted");
		TestListener.infoMessage("Deleted the Landing Page URL");
	}
	
	public void addCustodianInLandingPage() {
		wait.until(ExpectedConditions.visibilityOf(gearIconEdit));
		gearIconEdit.click();
		wait.until(ExpectedConditions.visibilityOf(buttonDeleteLandingPage));
		dropDownSelectCustodianName.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		inputCustodianName.click();
		inputCustodianName.sendKeys("Automation Testing");
		inputCustodianName.sendKeys(Keys.ENTER);
		System.out.println("Adding Custodian in Landing Page");
		TestListener.infoMessage("Adding Custodian in Landing Page");
		TestListener.addDynamicScreenshotInReport("addCustodianName");
		buttonAddCustodian.click();
	}
	
	public void removeCustodian() {
		buttonRemoveCustodian.click();
		System.out.println("Remove Custodian in Landing Page");
		TestListener.infoMessage("Remove Custodian in Landing Page");
		TestListener.addDynamicScreenshotInReport("removeCustodianName");
	}
	
	public void selectDestinationCustodian(String destinationCustodianName) {
		Select select = new Select(driver.findElement(By.name("custodian_route[destination_custodian_id]")));
		select.selectByVisibleText(destinationCustodianName);
	}
	
	public void editAdminEnterprise(Boolean removeUser) {
		wait.until(ExpectedConditions.elementToBeClickable(editIconAdminEnterprise));
		editIconAdminEnterprise.click();
		wait.until(ExpectedConditions.elementToBeClickable(editAddNewAccount));
		editAddNewAccount.click();
		System.out.println("Edit the New Admin Automation Enterprises");
		TestListener.infoMessage("Edit the New Admin Automation Enterprises");
		wait.until(ExpectedConditions.visibilityOf(headingAddNewAccountContact));
		inputAccountContactName.sendKeys("Automation Testing Name");
		inputAccountContactEmail.sendKeys("automation@automation.com");
		inputAccountContactPhone.sendKeys("1234567890");
		System.out.println("Adding Custodian Contact From Admin Enterprise");
		TestListener.infoMessage("Adding Custodian Contact From Admin Enterprise");
		TestListener.addDynamicScreenshotInReport("addingCustodianContact");
		buttonAdminEnterpriseSave.click();
		buttonAdminEnterpriseClose.click();
		verifyNewEnterpriseAdminAdd();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(editIconAdminEnterprise));
		editIconAdminEnterprise.click();
		wait.until(ExpectedConditions.visibilityOf(inputUserNameAdminEnterprise));
		inputUserNameAdminEnterprise.click();
		String verifyURL=driver.getCurrentUrl();
		if (verifyURL.contains("preproduction")) {
			inputUserNameAdminEnterprise.sendKeys("custodian.automation@test.com");
			inputUserNameAdminEnterprise.sendKeys(Keys.ENTER);
		} else {
			inputUserNameAdminEnterprise.sendKeys("custodian.automation@test.com");
			inputUserNameAdminEnterprise.sendKeys(Keys.ENTER);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonAdduser));
		buttonAdduser.click();
		System.out.println("Adding Custodian User From Admin Enterprise");
		TestListener.infoMessage("Adding Custodian User From Admin Enterprise");
		TestListener.addDynamicScreenshotInReport("addingCustodianUser");
		if (removeUser) {
			removeUserAdminEnterprise();
		}
		TestUtil.hardWait(5);
	}
	
	public void removeUserAdminEnterprise() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonRemoveUserAdminEnterprise));
		buttonRemoveUserAdminEnterprise.click();
		System.out.println("Removing Custodian Contact From Admin Enterprise");
		TestListener.infoMessage("Remove Custodian Contact From Admin Enterprise");
		TestListener.addDynamicScreenshotInReport("removeCustodianContact");
		wait.until(ExpectedConditions.elementToBeClickable(buttonOKDeleteAccountContact));
		buttonOKDeleteAccountContact.click();
		System.out.println("Removed Custodian Contact From Admin Enterprise");
		TestUtil.hardWait(5);
		TestListener.addDynamicScreenshotInReport("removedCustodianContact");
	}
	
	public void EnterprisesPresent() {
		wait.until(ExpectedConditions.visibilityOf(adminEnterpriseTab));
		adminEnterpriseTab.click();
		wait.until(ExpectedConditions.visibilityOf(headingAutomationTesting));
		if (TestUtil.isElementDisplayed(headingAutomationTesting)) {
			//removeOrganizationEnterprise();
			removeEnterpriseAdd();
		} 
		else {
			System.out.println("NOT FOUND");
		}
	}
}

