package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class UserRolesAndPermission extends BrowserConfiguration{

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'User Roles & Permissions')]")
	WebElement adminDropDownUserRolesAndPermissionsPage;
	
	@FindBy(xpath = "//div[@id='notice-message']")
	WebElement statusMessage;
	
	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	WebElement userNameDropDown;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'User Roles & Permissions')]")
	WebElement verifyValueUserRolesAndPermissions;
		
	public UserRolesAndPermission() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Open the User Roles And Permission Page from the admin page
	 */
	public void openAdminUserRoleAndPermissionPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownUserRolesAndPermissionsPage));
		adminDropDownUserRolesAndPermissionsPage.click();
	}
	
	public void changeRoleAssignedAdministratorToStandardUser(String emailID) {
		TestUtil.hardWait(5);
		WebElement radioButtonAdministrator=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[1]"));
		WebElement radioButtonStandardUser=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[2]"));
		if (radioButtonAdministrator.isSelected()) {
			radioButtonStandardUser.click();
			TestUtil.hardWait(5);
		}
		else {
			radioButtonAdministrator.click();
			TestUtil.hardWait(5);
		}
	}
	
	public void changeRoleAssignedStandardUserToViewOnlyUser(String emailID) {
		TestUtil.hardWait(5);
		WebElement radioButtonStandardUser=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[2]"));
		WebElement radioButtonViewOnlyUser=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[3]"));
		if (radioButtonStandardUser.isSelected()) {
			radioButtonViewOnlyUser.click();
			TestUtil.hardWait(5);
		}
		else {
			radioButtonStandardUser.click();
			TestUtil.hardWait(5);
		}
	}
	
	public void changeRoleAssignedViewOnlyUserToAdministrator(String emailID) {
		TestUtil.hardWait(5);
		WebElement radioButtonAdministrator=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[1]"));
		WebElement radioButtonViewOnlyUser=driver.findElement(By.xpath("//td[contains(text(),'"+emailID+"')]/following::label[3]"));
		if (radioButtonViewOnlyUser.isSelected()) {
			radioButtonAdministrator.click();
			TestUtil.hardWait(5);
		}
		else {
			radioButtonViewOnlyUser.click();
			TestUtil.hardWait(5);
		}
	}
	
	public void verifyChangedUser() {
		wait.until(ExpectedConditions.elementToBeClickable(userNameDropDown));
		userNameDropDown.click();
		if (TestUtil.isElementDisplayed(verifyValueUserRolesAndPermissions)) {
			System.out.println("The Assign To The User is Administaror");
			TestListener.infoMessage("The Assign To The User is Administaror");
		} else {
			System.out.println("The Assign To The User is Standard User/ View Only Permission");
			TestListener.infoMessage("The Assign To The User is Standard User/ View Only Permission");
		}
	}
}
