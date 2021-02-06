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

public class AdminBlockedFaxNumberPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	CreateRequest createRequest = new CreateRequest();

	public AdminBlockedFaxNumberPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[@href='/company/blocked_fax_numbers']")
	WebElement adminBlockedFaxNumberPage;

	@FindBy(xpath = "//h1[normalize-space()='Blocked Fax Numbers']")
	WebElement headingBlockedFaxNumber;

	 @FindBy(xpath = "//input[@id='blocked-fax-number']")
	//@FindBy(xpath = "//input[@id='request-fax-number']")
	WebElement inputFaxNumber;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSave;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement statusMessage;

	@FindBy(xpath = "//td[normalize-space()='1-123-456-7890']")
	WebElement addedBlockFaxNumber;

	@FindBy(xpath = "//span[contains(text(),'Select Requestor Type')]")
	WebElement inputSelectRequestorType;

	@FindBy(xpath = "//span[contains(text(),'Select Frequent Requestor')]")
	WebElement inputSelectFrequentRequestor;

	// @FindBy(xpath = "//ul[contains(@class,'services-list delivery')]//label[1]")
	@FindBy(xpath = "//ul[@class='services-list delivery']//input[@id='request_service_2']")
	WebElement radioFaxButton;

	@FindBy(xpath = "//a[normalize-space()='Send to Provider']")
	WebElement buttonSendProvider;

	@FindBy(xpath = "//b[normalize-space()='Approve Estimate']")
	WebElement buttonApproveEstimate;

	@FindBy(xpath = "//span[normalize-space()='MasterCard']")
	WebElement radioButtonMasterCard;

	@FindBy(xpath = "//a[normalize-space()='Pay By Check']")
	WebElement buttonPayByCheck;

	@FindBy(xpath = "//span[normalize-space()='Save Changes to Form']")
	WebElement buttonSaveChangesToForm;

	@FindBy(xpath = "//a[@href='/custodian?status=completed']")
	WebElement tabCompletedRequest;

	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;

	@FindBy(xpath = "//table[@class='main-table table-striped request-container table-condensed']/tbody/tr[1]/td[3]")
	WebElement openFirstRequest;

	@FindBy(xpath = "//a[normalize-space()='Send Fax']")
	WebElement buttonSendFax;

	@FindBy(xpath = "//a[normalize-space()='Fax Records + Invoice']")
	WebElement buttonDropDownSendFaxRecordsAndInvoice;

	@FindBy(xpath = "//div[@id='fax-detailes-modal']//span[@class='pull-right']")
	WebElement buttonSendFaxCompletedRequestModule;

	@FindBy(xpath = "//div[@id='fax-detailes-modal']//span[@class='pull-right']/input")
	WebElement buttonSendFaxCompletedRequestModuleInput;

	@FindBy(xpath = "//input[@id='fax_number_format']")
	WebElement inputFaxNumberBlockedFax;
	
	@FindBy(xpath = "//input[@id='request-fax-number']")
	WebElement inputFaxNumberRequestCreation;

	public void openBlockedFaxNumberPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(adminBlockedFaxNumberPage));
		adminBlockedFaxNumberPage.click();
		TestListener.infoMessage("Open Admin Blocked Fax Number Page");
		wait.until(ExpectedConditions.visibilityOf(headingBlockedFaxNumber));
	}

	public void addBlockFaxNumber(String FaxNumberForBlocked) {
		wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumber));
		inputFaxNumber.sendKeys(FaxNumberForBlocked);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSave));
		buttonSave.click();
		confrimationMessage();

	}

	public void confrimationMessage() {
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		if (TestUtil.isElementDisplayed(statusMessage)) {
			String tempMessage = statusMessage.getText();
			if (tempMessage.contains("Blocked Fax Number successfully created")) {
				System.out.println("Number Added into Blocked Fax Number List");
				TestListener.infoMessage("Number Added into Blocked Fax Number List");
				TestListener.addDynamicScreenshotInReport("confrimationMessage");
			} else if (tempMessage.contains("Blocked Fax Number was removed successfully")) {
				System.out.println("Number Deleted From Blocked Fax Number List");
				TestListener.infoMessage("Number Deleted From Blocked Fax Number List");
				TestListener.addDynamicScreenshotInReport("confrimationMessage");
			} else {
				System.out.println("No Number Found in Blocked Fax Number List");
				TestListener.infoMessageFail("No Number Found in Blocked Fax Number List");
				TestListener.addDynamicScreenshotInReport("confrimationMessage");
			}
		} else {
			System.out.println("Blocked Fax Number Not Saved");
			TestListener.addDynamicScreenshotInReport("confrimationMessage");
		}
	}

	public void deleteBlockFaxNumber(String FaxNumber) {
		if (TestUtil.isElementDisplayed(addedBlockFaxNumber)) {
			wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumber));
			driver.findElement(By.xpath(
					"//table[@class='main-table table']/tbody/tr/td/a[@data-confirm='Are you sure, you want to remove 1"
							+ FaxNumber + " blocked fax number?']"))
					.click();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			confrimationMessage();
			System.out.println("Blocked Fax Number Remove From The list Successfully " + FaxNumber);
			TestListener.infoMessage("Blocked Fax Number Remove From The list Successfully " + FaxNumber);
			TestListener.addDynamicScreenshotInReport("deleteBlockFaxNumber");
		} else {
			System.out.println("Blocked Fax Number Not Found " + FaxNumber);
			TestListener.infoMessageFail("Blocked Fax Number Not Found " + FaxNumber);
			TestListener.addDynamicScreenshotInReport("deleteBlockFaxNumber");
		}
	}

	public void sentFaxblockedNumber(String blockedFaxNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@class='main-table table-striped table-condensed']/tbody/tr[1]/td[2]/a"))));
		driver.findElement(By.xpath("//table[@class='main-table table-striped table-condensed']/tbody/tr[1]/td[2]/a")).click();
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(inputSelectRequestorType))
		 * ; inputSelectRequestorType.click();
		 * driver.findElement(By.xpath("//li[contains(text(),'Health Care Provider')]"))
		 * .click(); wait.until(ExpectedConditions.elementToBeClickable(
		 * inputSelectFrequentRequestor)); inputSelectFrequentRequestor.click();
		 * driver.findElement(By.xpath("//li[contains(text(),'Automation Custodian')]"))
		 * .click();
		 */
		//String tempRequestNo=createRequest.getRequestNo();
		wait.until(ExpectedConditions.elementToBeClickable(radioFaxButton));
		radioFaxButton.click();
		inputFaxNumberRequestCreation.clear();
		inputFaxNumberRequestCreation.sendKeys(blockedFaxNumber);
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(buttonSendProvider));
		 * buttonSendProvider.click();
		 * wait.until(ExpectedConditions.elementToBeClickable(buttonApproveEstimate));
		 * buttonApproveEstimate.click();
		 * wait.until(ExpectedConditions.elementToBeClickable(radioButtonMasterCard));
		 * radioButtonMasterCard.click();
		 * wait.until(ExpectedConditions.elementToBeClickable(buttonPayByCheck));
		 * buttonPayByCheck.click();
		 */
		driver.findElement(By.xpath("//button[@class='btn check_archive_records_date pr5 mb10']")).click();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("prevent fax-backs from reaching this number")) {
			System.out.println("Fax Number is in Blocker Queue");
			TestListener.infoMessage("Fax Number is in Blocker Queue");
			TestListener.addDynamicScreenshotInReport("sentFaxblockedNumber");
		} else {
			System.out.println("Fax Number NOT in Blocker Queue");
			TestListener.infoMessageFail("Fax Number NOT in Blocker Queue");
			TestListener.addDynamicScreenshotInReport("sentFaxblockedNumber");
		}
	}

	public void sendFaxOnCompletedRequest(String FaxNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(tabCompletedRequest));
		tabCompletedRequest.click();
		wait.until(ExpectedConditions.elementToBeClickable(openFirstRequest));
		openFirstRequest.click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSendFax));
		buttonSendFax.click();
		wait.until(ExpectedConditions.visibilityOf(buttonDropDownSendFaxRecordsAndInvoice));
		buttonDropDownSendFaxRecordsAndInvoice.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumberBlockedFax));
		inputFaxNumberBlockedFax.sendKeys(FaxNumber);
		TestListener.addDynamicScreenshotInReport("sendFaxOnCompletedRequest");
	}
}