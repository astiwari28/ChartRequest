package com.ChartRequest.Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class EMRCredentialsPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	@FindBy(xpath = "//a[contains(text(),'Click To View/Edit')]")
	WebElement linkAddEMR;

	@FindBy(xpath = "//li[contains(text(),'EMR Credentials')]")
	WebElement tabEmrCredentials;

	@FindBy(xpath = "//li[contains(text(),'Remote Access / VPN Credentials')]")
	WebElement tabRemoteAccessAndVPNCredentials;

	@FindBy(xpath = "//a[contains(text(),'Back to Automation Custodian')]")
	WebElement linkBackToAutomationCustodian;

	@FindBy(xpath = "//input[@value='Add New EMR']")
	WebElement buttonAddNewEMR;
	
	@FindBy(xpath = "//input[@value='Add New Remote Access / VPN']")
	WebElement buttonAddNewVPN;

	@FindBy(xpath = "//select[@id='system_of_record_id']")
	WebElement selectSystemOfRecords;

	@FindBy(xpath = "//input[@value='medical']")
	WebElement checkboxRecordTypeMedical;

	@FindBy(xpath = "//input[@value='billing']")
	WebElement checkboxRecordTypeBilling;

	@FindBy(xpath = "//input[@value='images']")
	WebElement checkboxRecordTypeImages;

	@FindBy(xpath = "//input[@id='start_date']")
	WebElement inputStartDate;

	@FindBy(xpath = "//input[@id='end_date']")
	WebElement inputEndDate;

	@FindBy(xpath = "//input[@id='is_recurring_end_date']")
	WebElement checkboxCurrent;// Donot Know Usage

	@FindBy(xpath = "//input[@id='link']")
	WebElement inputLink;

	@FindBy(xpath = "//input[@id='username']")
	WebElement inputUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@id='password_expire_on']")
	WebElement inputChooseExpireDate;

	@FindBy(xpath = "//textarea[@id='notes']")
	WebElement textareaNotes;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement buttonSave;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement statusMessage;
	
	@FindBy(xpath = "//li[@id='your_account']/a[@href='/account']")
	WebElement tabMyAccount;
	
	@FindBy(xpath = "//dt[normalize-space()='Organization']/following::dd[1]")
	WebElement getOrganizationName;
	
	@FindBy(xpath = "//div[@class='heading requestor']")
	WebElement headingRequestor;
	
	@FindBy(xpath = "//a[contains(text(),'Back to')]")
	WebElement linkBackToCustodianPage;
	
	@FindBy(xpath = "//a[contains(text(),'Edit General Settings')]")
	WebElement buttonEditGeneralSetting;
	
	@FindBy(xpath = "//*[@id='widget_core']")
	WebElement buttonTeam;
	
	@FindBy(xpath = "//a[normalize-space()='EMR Access']")
	WebElement linkEMRAccess;
	
	@FindBy(xpath = "//tbody[@class='request-container']/tr[1]/td[1]")
	WebElement textSystemOfRecords;

	public EMRCredentialsPage() {
		PageFactory.initElements(driver, this);
	}

	public void addEMRUser() {
		wait.until(ExpectedConditions.elementToBeClickable(linkAddEMR));
		linkAddEMR.click();
		wait.until(ExpectedConditions.elementToBeClickable(tabEmrCredentials));
		tabEmrCredentials.click();
		TestListener.infoMessage("Opening The EMR Credentials");
		TestListener.addDynamicScreenshotInReport("addEMRUser");
	}

	public void addCredentials(boolean EMR,String nameOFSystemRecords, String startDate, String linkURL, String userName, String password,
			String notes) {
		TestUtil.hardWait(5);
		if (EMR) {
			buttonAddNewEMR.click();
		} else {
			buttonAddNewVPN.click();
		}	
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(selectSystemOfRecords));
		selectSytemOfRecords(nameOFSystemRecords);
		// Select Record Type Medical
		checkboxRecordTypeMedical.click();
		// Enter the Start Date And End Date
		inputStartDate.click();
		inputStartDate.sendKeys(startDate);
		inputEndDate.click();
		inputEndDate.sendKeys(Keys.ENTER);
		// input Link
		inputLink.sendKeys(linkURL);
		// Enter UserName And Password
		inputUserName.sendKeys(userName);
		inputPassword.sendKeys(password);
		// Enter Expire Date
		inputChooseExpireDate.sendKeys(Keys.ENTER);
		// Enter The notes
		textareaNotes.sendKeys(notes);
		// Save Button
		TestListener.infoMessage("Entering The Details");
		TestListener.addDynamicScreenshotInReport("detailsInForm");
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		String message = statusMessage.getText();
		if (message.contains("System credentials saved successfully")) {
			System.out.println("EMR Credentials Saved Successfully");
			TestListener.infoMessage("EMR Credentials Saved Successfully");
			TestListener.addDynamicScreenshotInReport("EMRCredentialsSavedSuccessfully");
		} else {
			System.out.println("EMR Credentials NOT-Saved successfully");
			TestListener.infoMessageFail("EMR Credentials NOT-Saved successfully");
			TestListener.addDynamicScreenshotInReport("EMRCredentialsNotSavedSuccessfully");
		}
	}

	public void selectSytemOfRecords(String nameOFSystemRecords) {
		Select selectSystemRecords = new Select(driver.findElement(By.name("system_of_record_id")));
		selectSystemRecords.selectByVisibleText(nameOFSystemRecords);
	}

	public void deleteEMRCredentials(String sytemRecordName) {
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//span[normalize-space()='" + sytemRecordName + "']//i"))));
		TestUtil.hardWait(3);
		boolean visible= TestUtil.isElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+sytemRecordName+"')]")));
		if (visible) {
			driver.findElement(By.xpath("//span[contains(text(),'"+sytemRecordName+"')]/ancestor::tr/td[@class='align-right']/span[@class='del_btn']")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.visibilityOf(statusMessage));
			String message = statusMessage.getText();
			if (message.contains("System credentials deleted successfully")) {
				System.out.println("EMR Credentials Deleted successfully");
				TestListener.infoMessage("EMR Credentials Deleted successfully");
				TestListener.addDynamicScreenshotInReport("EMRCredentialsDeletedSuccessfully");
			} else {
				System.out.println("EMR Credentials NOT-Deleted successfully");
				TestListener.infoMessageFail("EMR Credentials Deleted successfully");
				TestListener.addDynamicScreenshotInReport("EMRCredentialsNotDeletedSuccessfully");
			}
			System.out.println("Delete The EMR Credentials");
		} else {
			System.out.println("Unable To Delete The EMR Credentials");
			TestListener.infoMessageFail("Unable To Delete The EMR Credentials");
			TestListener.addDynamicScreenshotInReport("UnableToDeleteTheEMRCredentials");
		}
	}
	
	public void addVpnUser() {
		wait.until(ExpectedConditions.elementToBeClickable(linkAddEMR));
		linkAddEMR.click();
		wait.until(ExpectedConditions.elementToBeClickable(tabRemoteAccessAndVPNCredentials));
		tabRemoteAccessAndVPNCredentials.click();
	}
	
	public String getOrganizationName() {
		wait.until(ExpectedConditions.visibilityOf(tabMyAccount));
		tabMyAccount.click();
		wait.until(ExpectedConditions.visibilityOf(getOrganizationName));
		String organizationName=getOrganizationName.getText();
		System.out.println("Organization Name is "+organizationName);
		return organizationName;
	}
	
	public void verifyHeading(String organzationName) {
		wait.until(ExpectedConditions.visibilityOf(headingRequestor));
		String actualHeading=headingRequestor.getText();
		String expectedHeading=organzationName+" System Credentials";
		if (actualHeading.contentEquals(expectedHeading)) {
			System.out.println("Heading Matched");
			TestListener.infoMessage("Heading Matched");
			TestListener.addDynamicScreenshotInReport("HeadingMatched");
		} else {
			System.out.println("Heading NOT-Matched");
			TestListener.infoMessageFail("Heading NOT-Matched");
			TestListener.addDynamicScreenshotInReport("HeadingNotMatched");
		}
	}
	
	public void editDetails(String sytemRecordName,String newlinkURL,String newnotes) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'"+sytemRecordName+"')]/ancestor::tr/td[@class='align-right']/span[@class='edit_btn']"))));
		driver.findElement(By.xpath("//span[contains(text(),'"+sytemRecordName+"')]/ancestor::tr/td[@class='align-right']/span[@class='edit_btn']")).click();
		wait.until(ExpectedConditions.visibilityOf(inputLink));
		inputLink.clear();
		inputLink.sendKeys(newlinkURL);
		textareaNotes.clear();
		textareaNotes.sendKeys(newnotes);
		buttonSave.click();
		TestListener.infoMessage("Editing in Saved Details "+sytemRecordName+" newLinkURL "+newlinkURL+" New Notes "+newnotes);
		TestListener.addDynamicScreenshotInReport("editingDetails");
	}
	
	public void verifyNewDetailsSavedVPN(String sytemRecordName,String newlinkURL,String newNotes) {
		wait.until(ExpectedConditions.elementToBeClickable(tabRemoteAccessAndVPNCredentials));
		tabRemoteAccessAndVPNCredentials.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[normalize-space()='"+sytemRecordName+"']//i[@class='fa fa-angle-down']"))));
		driver.findElement(By.xpath("//span[normalize-space()='"+sytemRecordName+"']//i[@class='fa fa-angle-down']")).click();
		String tempUrl=driver.findElement(By.xpath("//a[normalize-space()='"+newlinkURL+"']")).getText();
		if (tempUrl.contains(newlinkURL)) {
			System.out.println("URL Changed Successfully");
			TestListener.infoMessage("URL Changed Successfully");
			TestListener.addDynamicScreenshotInReport("URLChangedSuccessfully");
		} else {
			System.out.println("URL NOT-Changed Successfully");
			TestListener.infoMessageFail("URL NOT-Changed Successfully");
			TestListener.addDynamicScreenshotInReport("URLNotChangedSuccessfully");
		}
		String tempNotes=driver.findElement(By.xpath("//span[contains(text(),'"+newNotes+"')]")).getText();
		if (tempNotes.contains(newNotes)) {
			System.out.println("Notes Changed Successfully");
			TestListener.infoMessage("Notes Changed Successfully");
			TestListener.addDynamicScreenshotInReport("NotesChangedSuccessfully");
		} else {
			System.out.println("Notes NOT-Changed Successfully");
			TestListener.infoMessageFail("Notes NOT-Changed Successfully");
			TestListener.addDynamicScreenshotInReport("NotesNotChangedSuccessfully");
		}
	}
	
	public void verifyNewDetailsSavedEMR(String sytemRecordName,String newlinkURL,String newNotes) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(tabEmrCredentials));
		tabEmrCredentials.click();
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[normalize-space()='"+sytemRecordName+"']//i[@class='fa fa-angle-down']"))));
		driver.findElement(By.xpath("//span[normalize-space()='"+sytemRecordName+"']//i[@class='fa fa-angle-down']")).click();
		String tempUrl=driver.findElement(By.xpath("//a[normalize-space()='http://"+newlinkURL+"']")).getText().replaceAll("http://", "");
		if (tempUrl.contains(newlinkURL)) {
			System.out.println("URL Changed Successfully");
			TestListener.infoMessage("URL Changed Successfully");
			TestListener.addDynamicScreenshotInReport("URLChangedSuccessfully");
		} else {
			System.out.println("URL NOT-Changed Successfully");
			TestListener.infoMessageFail("URL NOT-Changed Successfully");
			TestListener.addDynamicScreenshotInReport("URLNotChangedSuccessfully");
		}
		String tempNotes=driver.findElement(By.xpath("//span[contains(text(),'"+newNotes+"')]")).getText();
		if (tempNotes.contains(newNotes)) {
			System.out.println("Notes Changed Successfully");
			TestListener.infoMessage("Notes Changed Successfully");
			TestListener.addDynamicScreenshotInReport("NotesChangedSuccessfully");
		} else {
			System.out.println("Notes NOT-Changed Successfully");
			TestListener.infoMessageFail("Notes NOT-Changed Successfully");
			TestListener.addDynamicScreenshotInReport("NotesNotChangedSuccessfully");
		}
	}
	
	public List<String> listofUserFromDB() {

		Connection c = null;
		Statement stmt = null;
		List<String> listofName = new ArrayList<String>();
		try {
			Class.forName("org.postgresql.Driver");
			// c =
			// DriverManager.getConnection("jdbc:postgresql://localhost.aptible.in:45293/db",
			// "aptible","gAQC_kwP980NYI-DEhlYF7DAuz-o21P-");
			c = DriverManager.getConnection(
					"jdbc:postgresql://" + GlobalVariables.productionHostName + ":" + GlobalVariables.productionPortNo
							+ "/" + GlobalVariables.productionDatabaseName,
					GlobalVariables.productionUserName, GlobalVariables.productionDBPassword);

			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"system_of_records\".\"record\" FROM \"system_of_records\" ORDER BY \"system_of_records\".\"record\" Asc;");
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("Name is " + name);
				listofName.add(name);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully" + listofName);
		TestListener.infoMessage("List of Name From DataBase " + listofName);
		return listofName;
	}
	
	public List<String> getlistFromDropEMR() {
		List<String> listofNameFromEMRDrop = new ArrayList<String>();
		TestUtil.hardWait(5);
		buttonAddNewEMR.click();
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//select[@id='system_of_record_id']")).click();
		WebElement categoriesDropDown=driver.findElement(By.xpath("//select[@id='system_of_record_id']"));
		Select categories = new Select(categoriesDropDown);
		List<WebElement> optionsList = categories.getOptions();
		System.out.println("Size of list is :- "+optionsList.size());
		TestUtil.hardWait(5);
		for (WebElement option : optionsList) {
		              System.out.println(option.getText());
		              listofNameFromEMRDrop.add(option.getText());    
		}
		TestListener.infoMessage("List of Name From EMR Drop Down " + listofNameFromEMRDrop);
		return listofNameFromEMRDrop;
	}
	
	public List<String> getlistFromDropVPN() {
		List<String> listofNameFromVPNDrop = new ArrayList<String>();
		TestUtil.hardWait(5);
		buttonAddNewVPN.click();
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//select[@id='system_of_record_id']")).click();
		WebElement categoriesDropDown=driver.findElement(By.xpath("//select[@id='system_of_record_id']"));
		Select categories = new Select(categoriesDropDown);
		List<WebElement> optionsList = categories.getOptions();
		System.out.println("Size of list is :- "+optionsList.size());
		TestUtil.hardWait(5);
		for (WebElement option : optionsList) {
		              System.out.println(option.getText());
		              listofNameFromVPNDrop.add(option.getText());    
		}
		TestListener.infoMessage("List of Name From VPN Drop Down " + listofNameFromVPNDrop);
		return listofNameFromVPNDrop;
	}
	
	public void verifyEMRandDB(List<String> dbList,List<String> emrDropDown) {
		dbList.removeAll(emrDropDown);
		System.out.println("Not Present in List is "+dbList);
		TestListener.infoMessage("Not Present in List is Drop Down"+dbList);
	}
	
	public void backToCustodianPage() {
		wait.until(ExpectedConditions.elementToBeClickable(linkBackToCustodianPage));
		linkBackToCustodianPage.click();
		wait.until(ExpectedConditions.visibilityOf(buttonEditGeneralSetting));
		if (TestUtil.isElementDisplayed(buttonEditGeneralSetting)) {
			System.out.println("Landed To Custodian Setting Page");
			TestListener.infoMessage("Landed To Custodian Setting Page");
			TestListener.addDynamicScreenshotInReport("backToCustodianPage");
		} else {
			System.out.println("NOT-Landed To Custodian Setting Page");
			TestListener.infoMessage("NOT-Landed To Custodian Setting Page");
			TestListener.addDynamicScreenshotInReport("backToCustodianPage");
		}
	}
	
	public void verifyEMRAccessClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonTeam));
		buttonTeam.click();
		wait.until(ExpectedConditions.elementToBeClickable(linkEMRAccess));
		if (TestUtil.isClickable(linkEMRAccess)) {
			System.out.println("User Can Click on EMR Access");
			linkEMRAccess.click();
		} else {
			System.out.println("User CanNot Click on EMR Access");
		}
	}
	
	public List<String> getSystemOfRecords() {
		List<String> nameSystemOfRecords=new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOf(textSystemOfRecords));
		int noOfSystemOfRecords=driver.findElements(By.xpath("//tbody[@class='request-container']/tr")).size();
		for (int i = 1; i <=noOfSystemOfRecords; i++) {
			String tempText=driver.findElement(By.xpath("//tbody[@class='request-container']/tr["+i+"]/td[1]")).getText();
			System.out.println("Get System of Records "+tempText);
			nameSystemOfRecords.add(tempText);
		}
		TestListener.infoMessage("List of System Of Records "+nameSystemOfRecords);
		return nameSystemOfRecords;
	}	 
	
	public List<String> getSystemOfRecordsFromEMRAccess() {
		List<String> nameSystemOfRecords=new ArrayList<String>();
		TestUtil.hardWait(3);
		int noOfSystemOfRecords=driver.findElements(By.xpath("//div[@id='emr_access_body']/div")).size();
		for (int i = 1; i <=noOfSystemOfRecords; i++) {
			String tempText=driver.findElement(By.xpath("//div[@id='emr_access_body']/div["+i+"]/p[1]")).getText();
			System.out.println("Get System of Records From EMR"+tempText);
			nameSystemOfRecords.add(tempText);
		}
		TestListener.infoMessage("List of System Of Records "+nameSystemOfRecords);
		return nameSystemOfRecords;
	}	 
	
	public void verifyList(List<String> list1,List<String> list2) {
		for (String string1 : list1) {
			for (String string2 : list2) {
				if (string1.contains(string2.replaceAll("System Record ", ""))) {
					System.out.println("System of Records Matched "+string1+" String 2 "+string2);
					TestListener.infoMessage("System of Records Matched "+string1+" String 2 "+string2);
					break;
				} else {
					System.out.println("System of Records NOT-Matched "+string1+" String 2 "+string2);
					TestListener.infoMessageFail("System of Records NOT-Matched "+string1+" String 2 "+string2);
					continue;
				}
			}
		}
	}
}