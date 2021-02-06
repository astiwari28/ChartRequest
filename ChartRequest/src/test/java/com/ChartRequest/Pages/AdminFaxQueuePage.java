package com.ChartRequest.Pages;

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
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class AdminFaxQueuePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	CreateRequest createRequest = new CreateRequest();

	public AdminFaxQueuePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[@href='/company/fax_queues']")
	WebElement adminFaxQueuePage;

	@FindBy(xpath = "//h4[normalize-space()='Fax Queue']")
	WebElement headingFaxQueue;

	@FindBy(xpath = "//a[@href='/company/fax_queues?fax_group=custodian']")
	WebElement tabCustodian;

	@FindBy(xpath = "//a[@href='/company/fax_queues?fax_group=fax2']")
	WebElement tabFax2;

	@FindBy(xpath = "//a[@href='/company/fax_queues?fax_group=concentra']")
	WebElement tabConcentra;

	@FindBy(xpath = "//a[@href='/company/fax_queues?fax_group=retrieval']")
	WebElement tabRetrieval;

	@FindBy(xpath = "//a[normalize-space()='Arrival Time']")
	WebElement sortByArrivalTime;

	@FindBy(xpath = "//table[@class='table fax-table']/tbody/tr[1]/td[1]")
	WebElement getFaxID;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[1]")
	WebElement getArchieveFaxId;

	@FindBy(xpath = "//input[@id='request_patient_attributes_given_names']")
	WebElement inputFirstName;

	@FindBy(xpath = "//input[@id='request_patient_attributes_family_name']")
	WebElement inputLastName;

	@FindBy(xpath = "//input[@id='request_patient_attributes_date_of_birth']")
	WebElement inputDateOFBirth;

	@FindBy(xpath = "//*[@id='confirmation_mail_to_chosen']/a/span")
	WebElement dropDownClientEmailAddress;

	@FindBy(xpath = "//*[@id='confirmation_mail_to_chosen']/div/div/input")
	WebElement inputEmailIDForConfrimation;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement alertNotice;

	@FindBy(xpath = "//tbody/tr[1]//button[normalize-space() = 'Show Attachment']")
	WebElement buttonPresenceoFShowAttachment;

	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[1]")
	WebElement getFaxIDArchievedType;

	@FindBy(xpath = "//*[@id='faxback_custodian_id_chosen']/a")
	WebElement dropDownSelectCustodian;

	@FindBy(xpath = "//*[@id='faxback_custodian_id_chosen']/div/div/input")
	WebElement inputElementCustodianName;

	@FindBy(xpath = "//input[@id='patient_name']")
	WebElement inputPatientName;

	@FindBy(xpath = "//input[@id='send-fax-back']")
	WebElement buttonSendFaxBack;

	@FindBy(xpath = "//button[@id='submit-send-fax']")
	WebElement buttonConfrimationFaxBack;

	@FindBy(xpath = "//div[contains(text(),'No results found.')]")
	WebElement noResultFound;
	
	@FindBy(xpath = "//table[@class='table fax-table']/tbody/tr[1]/td[3]")
	WebElement getFaxNo;
	
	@FindBy(xpath = "//button[normalize-space()='Filter & Search']")
	WebElement buttonFilterAndSearch;
	
	@FindBy(xpath = "//span[@class='col-sm-4 col-xs-12 filter-chosen']//input[@id='filter_fax_number']")
	WebElement inputFaxNumber;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearchFilter;
	
	@FindBy(xpath = "//table[@class='table fax-table']/tbody/tr[1]")
	WebElement searchResult;
	
	public void openFaxQueuePage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(adminFaxQueuePage));
		adminFaxQueuePage.click();
		TestListener.infoMessage("Open Admin Fax Queue Page");
		wait.until(ExpectedConditions.visibilityOf(headingFaxQueue));
	}

	public boolean createRequestFromFax() {
		boolean flag=false;
		if (TestUtil.isElementDisplayed(noResultFound)) {
			System.out.println("No Operation Performed");
			flag=false;
		} else {
			sortByArrivalTime();
			String tempFaxID = getFaxID();
			driver.findElement(By.xpath("//a[@id='" + tempFaxID + "']")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(
					By.xpath("//li[@id='tab_assign_request" + tempFaxID + "']//a[contains(text(),'Assign')]"))));
			// driver.findElement(By.xpath("//div[@id='custodian_id"+tempFaxID+"_chosen']//span[contains(text(),'Select
			// Custodian')]")).click();
			driver.findElement(By.xpath("//*[@id='custodian_id" + tempFaxID + "_chosen']/a/span")).click();
			// driver.findElement(By.xpath("//div[id='custodian_id"+tempFaxID+"_chosen']
			// input[@type='text']")).sendKeys("Automation Custodian");
			driver.findElement(By.xpath("//*[@id='custodian_id" + tempFaxID + "_chosen']/div/div/input"))
					.sendKeys("Automation Custodian - IN");
			driver.findElement(By.xpath("//*[@id='custodian_id" + tempFaxID + "_chosen']/div/div/input"))
					.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[@id='assign_request" + tempFaxID
					+ "']//div[contains(@class,'centered')]//input[contains(@value,'')]")).click();
			// Patient Information
			wait.until(ExpectedConditions.elementToBeClickable(inputFirstName));
			inputFirstName.sendKeys("Automation");
			inputLastName.sendKeys("Test");
			inputDateOFBirth.sendKeys("01011991");
			inputDateOFBirth.sendKeys(Keys.ENTER);
			// Request Details-Record Type
			driver.findElement(By.xpath("//*[@id='scope" + tempFaxID + "_chosen']/ul/li/input")).click();
			driver.findElement(By.xpath("//*[@id='scope" + tempFaxID + "_chosen']/ul/li/input")).sendKeys("Medical");
			driver.findElement(By.xpath("//*[@id='scope" + tempFaxID + "_chosen']/ul/li/input")).sendKeys(Keys.ENTER);
			// Request Details-Reason For Request
			driver.findElement(By.xpath("//*[@id='reason" + tempFaxID + "_chosen']/ul/li/input")).click();
			driver.findElement(By.xpath("//*[@id='reason" + tempFaxID + "_chosen']/ul/li/input")).sendKeys("Other");
			driver.findElement(By.xpath("//*[@id='reason" + tempFaxID + "_chosen']/ul/li/input")).sendKeys(Keys.ENTER);
			// Request Details-Next Button
			driver.findElement(By.xpath("//a[@href='#request_service" + tempFaxID + "']")).click();
			// Service
			createRequest.selectAuthorizationType("AshutoshTLAuth");
			dropDownClientEmailAddress.click();
			inputEmailIDForConfrimation.sendKeys("@test");
			inputEmailIDForConfrimation.sendKeys(Keys.ENTER);
			driver.findElement(
					By.xpath("//div[@id='request_service" + tempFaxID + "']//div//input[@value='Assign & Archive']"))
					.click();
			flag=true;
		}
		return flag;
	}

	public void openTab(String TabName) {
		wait.until(ExpectedConditions.elementToBeClickable(tabCustodian));
		if (TabName.contains("Custodian")) {
			tabCustodian.click();
			System.out.println("Click on Custodian Tab");
			TestListener.infoMessage("Click on Custodian Tab");
		} else if (TabName.contains("Fax #2")) {
			tabFax2.click();
			System.out.println("Click on Fax #2 Tab");
			TestListener.infoMessage("Click on Fax #2 Tab");
		} else if (TabName.contains("Concentra")) {
			tabConcentra.click();
			System.out.println("Click on Concentra Tab");
			TestListener.infoMessage("Click on Concentra Tab");
		} else if (TabName.contains("Retrieval")) {
			tabRetrieval.click();
			System.out.println("Click on Retrieval Tab");
			TestListener.infoMessage("Click on Retrieval Tab");
		}
		TestListener.addDynamicScreenshotInReport("tabName");
	}

	public void sortByArrivalTime() {
		wait.until(ExpectedConditions.elementToBeClickable(sortByArrivalTime));
		sortByArrivalTime.click();
		System.out.println("Click on Arrival Time for Sorting");
		TestListener.infoMessage("Click on Arrival Time for Sorting");
		TestListener.addDynamicScreenshotInReport("sortByArrivalTime");
	}

	public String getFaxID() {
		String faxID = getFaxID.getText();
		System.out.println("Fax ID is: " + faxID);
		TestListener.infoMessage("Fax ID is: "+faxID);
		return faxID;
	}

	public void typeFaxQueCustodian(String typeFaxName) {
		System.out.println("Select The Type of Service is :- " + typeFaxName);
		TestListener.infoMessage("Click on Arrival Time for Sorting");
		TestListener.addDynamicScreenshotInReport("typeFaxQueCustodian");
		if (typeFaxName.contains("Sent")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues?fax_group=custodian&type=sent']")).click();
		} else if (typeFaxName.contains("Archive")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues/archive?fax_group=custodian&type=incoming']"))
					.click();
		}
	}

	public String getRequestNumber() {
		wait.until(ExpectedConditions.visibilityOf(alertNotice));
		String text = alertNotice.getText();
		String[] arrOfStr = text.split(" updated. Request", 2);
		System.out.println("value of First array of String is:- " + arrOfStr[0]);
		String tempRequestNo=arrOfStr[0].replaceAll("[^0-9]", "");
		System.out.println("Request No is:- " + tempRequestNo);
		TestListener.infoMessage("Request No is:- " + tempRequestNo);
		return tempRequestNo;
	}

	public void createRequestArchive() {
		wait.until(ExpectedConditions.visibilityOf(buttonPresenceoFShowAttachment));
		buttonPresenceoFShowAttachment.click();
		String archievedFaxID = getFaxIDArchievedType.getText();
		System.out.println("Fax ID is: " + archievedFaxID);
		TestListener.infoMessage("Archieved Fax ID is: "+archievedFaxID);
		driver.findElement(By.xpath("//button[@fax_id='" + archievedFaxID + "']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectCustodian));
		dropDownSelectCustodian.click();
		inputElementCustodianName.sendKeys(GlobalVariables.OrganizationName);
		inputElementCustodianName.sendKeys(Keys.ENTER);
		inputPatientName.sendKeys("Automation Testing");
		buttonSendFaxBack.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonConfrimationFaxBack));
		buttonConfrimationFaxBack.click();
		TestListener.addDynamicScreenshotInReport("createRequestArchive");
	}

	public void typeFaxQueFax2(String typeFaxName) {
		System.out.println("Select The Type of Service is :- " + typeFaxName);
		TestListener.infoMessage("Select The Type of Service is :- " + typeFaxName);
		TestListener.addDynamicScreenshotInReport("typeFaxQueFax2");
		if (typeFaxName.contains("Sent")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues?fax_group=fax2&type=sent']")).click();
		} else if (typeFaxName.contains("Archive")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues/archive?fax_group=fax2&type=incoming']"))
					.click();
		}
	}

	public void typeFaxQueConcentra(String typeFaxName) {
		System.out.println("Select The Type of Service is :- " + typeFaxName);
		TestListener.infoMessage("Select The Type of Service is :- " + typeFaxName);
		TestListener.addDynamicScreenshotInReport("typeFaxQueConcentra");
		if (typeFaxName.contains("Sent")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues?fax_group=concentra&type=sent']")).click();
		} else if (typeFaxName.contains("Archive")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues/archive?fax_group=concentra&type=incoming']"))
					.click();
		}
	}
	
	public void typeFaxQueRetrieval(String typeFaxName) {
		System.out.println("Select The Type of Service is :- " + typeFaxName);
		TestListener.infoMessage("Select The Type of Service is :- " + typeFaxName);
		TestListener.addDynamicScreenshotInReport("typeFaxQueConcentra");
		if (typeFaxName.contains("Sent")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues?fax_group=retrieval&type=sent']")).click();
		} else if (typeFaxName.contains("Archive")) {
			driver.findElement(By.xpath("//*[@href='/company/fax_queues/archive?fax_group=retrieval&type=incoming']"))
					.click();
		}
	}

	public String getFaxNumber() {
		wait.until(ExpectedConditions.visibilityOf(getFaxNo));
		String tempFaxNo=getFaxNo.getText().replaceAll("[-+]", "").trim();
		System.out.println("Orginal Fax Id is "+getFaxNo.getText());
		String tempNewFaxNo=tempFaxNo.substring(1);
		System.out.println("Modified Fax Id is "+tempNewFaxNo);
		return tempNewFaxNo;
	}
	
	public void filterAndSerach(String faxNo) {
		wait.until(ExpectedConditions.visibilityOf(buttonFilterAndSearch));
		buttonFilterAndSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumber));
		inputFaxNumber.sendKeys(faxNo);
		buttonSearchFilter.click();
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		if (TestUtil.isElementDisplayed(searchResult)) {
			System.out.println("Found the Fax Number");
			TestListener.infoMessage("Found the Fax Number");
		} else {
			System.out.println("NOT-Found the Fax Number");
			TestListener.infoMessageFail("NOT-Found the Fax Number");
		}
	}
	
	public String archieveFaxId() {
		sortByArrivalTime();
		String tempFaxID = getFaxID();
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//a[@id='" + tempFaxID + "']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("//ul[@id='tabs"+tempFaxID+"']//a[@class='btn btn-primary'][normalize-space()='Archive']"))));
		driver.findElement(
				By.xpath("//ul[@id='tabs"+tempFaxID+"']//a[@class='btn btn-primary'][normalize-space()='Archive']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		//wait.until(ExpectedConditions.visibilityOf(alertNotice));
		return tempFaxID;
	}
	
	public void verifyArchieveFaxId(String FaxID) {
		wait.until(ExpectedConditions.visibilityOf(buttonPresenceoFShowAttachment));
		String getFaxID=getArchieveFaxId.getText();
		if (getFaxID.equals(FaxID)) {
			System.out.println("Fax Id Found And its Archieve");
			TestListener.infoMessage("Fax Id Found And its Archieve");
		} else {
			System.out.println("Fax Id NOT-Found And its Archieve");
			TestListener.infoMessageFail("Fax Id NOT-Found And its Archieve");
		}
		TestListener.addDynamicScreenshotInReport("verifyArchieveFaxId");
	}
}
