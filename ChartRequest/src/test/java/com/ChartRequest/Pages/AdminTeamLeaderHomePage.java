package com.ChartRequest.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminTeamLeaderHomePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//li//a[contains(text(),'[adm] Team Leader Home')]")
	WebElement adminDropDownTeamLeaderHomePage;

	@FindBy(xpath = "//a[contains(text(),'+ Goal')]")
	WebElement buttonAddGoal;

	@FindBy(xpath = "//h4[normalize-space()='Add Goal']")
	WebElement headingTitleAddGoal;

	@FindBy(xpath = "//div[@class='col-sm-6 mt10 remove-padding']//input[@value='csa']")
	WebElement radioButtonCSA;

	@FindBy(xpath = "//div[@id='goal_csa_id_chosen']//input[@value='Select CSA']")
	WebElement inputCSAUserName;

	@FindBy(xpath = "//div[@class='col-sm-6 mt10 remove-padding']//input[@value='team']")
	WebElement radioButtonTeam;

	@FindBy(xpath = "//div[@id='goal_team_id_chosen']//input[@value='Select Team']")
	WebElement inputTeamName;

	@FindBy(xpath = "//input[@id='goal']")
	WebElement inputGoalNumber;

	@FindBy(xpath = "//button[@id='add_goal_btn']")
	WebElement buttonSaveGoal;

	@FindBy(xpath = "//button[normalize-space()='CSA']")
	WebElement buttonTabAlertCSA;

	@FindBy(xpath = "//div[@id='alert_csa_id_filter_chosen']//span")
	WebElement dropDownSelectAlertCSA;

	@FindBy(xpath = "//div[@id='alert_csa_id_filter_chosen']//input[@type='text']")
	WebElement inputAlertCSAUserName;

	@FindBy(xpath = "//div[@id='csa_alerts']/div/p[@class='team_leader_home_alert']/a")
	WebElement alertPresentCSA;

	@FindBy(xpath = "//div[@id='team_alerts']//p[2]")
	WebElement notAlertPresentMessage;

	@FindBy(xpath = "//div[@id='csa_alerts']/div/p[2][@class='team_leader_home_alert']/a")
	WebElement openRejectRequest;

	@FindBy(xpath = "//div[@id='ack_message']")
	WebElement acknowledgmentMessage;

	@FindBy(xpath = "//button[@class='close']")
	WebElement buttonCloseAlertPage;

	@FindBy(xpath = "//button[normalize-space()='Team']")
	WebElement buttonTabAlertTeam;

	@FindBy(xpath = "//span[contains(text(),'Select Team')]")
	WebElement dropDownSelectAlertTeam;

	@FindBy(xpath = "//div[@id='alert_team_id_filter_chosen']//input[@type='text']")
	WebElement inputAlertTeamUserName;

	@FindBy(xpath = "//button[normalize-space()='Alert']")
	WebElement buttonTabAlert;

	@FindBy(xpath = "//span[contains(text(),'Select Alert Type')]")
	WebElement dropDownSelectAlertType;

	@FindBy(xpath = "//div[@id='alert_type_filter_chosen']//input[@type='text']")
	WebElement inputAlertTypeUserName;

	@FindBy(xpath = "//div[@class='display-alerts']/div/p[2][@class='team_leader_home_alert']/a")
	WebElement openRejectRequestAlertType;

	@FindBy(xpath = "//div[@id='alert_type']/div/p[2][@class='team_leader_home_alert']/a")
	WebElement openRejectRequestAlertTypePreProduction;

	@FindBy(xpath = "//i[@data-id='addAlertModal']")
	WebElement buttonCreateAlert;

	@FindBy(xpath = "//div[contains(@class,'col-sm-6 remove-padding mt10')]//label[contains(text(),'Teams')]")
	WebElement radioButtonCreateAlertTeams;

	@FindBy(xpath = "//div[contains(@class,'col-sm-6 remove-padding mt10')]//label[contains(text(),'CSA Users')]")
	WebElement radioButtonCreateAlertCSAUsers;

	@FindBy(xpath = "//div[@id='alert_csa_id_chosen']//ul[@class='chosen-choices']")
	WebElement dropDownCreateAlertCSAUser;

	@FindBy(xpath = "//div[@id='alert_team_id_chosen']//input[contains(@value,'Select Team')]")
	WebElement dropDownCreateAlertTeam;

	@FindBy(xpath = "//div[@id='alert_csa_id_chosen']//input[contains(@value,'Select CSA')]")
	WebElement inputCreateAlertCSAName;

	@FindBy(xpath = "//span[normalize-space()='Low']")
	WebElement dropdowSelectPriority;

	@FindBy(xpath = "//div[@id='alert_priority_chosen']//input[contains(@type,'text')]")
	WebElement inputPriorityName;

	@FindBy(xpath = "//textarea[@id='alert_msg']")
	WebElement textAreaAlertMessage;

	@FindBy(xpath = "//label[normalize-space()='Acknowledge']")
	WebElement checkboxAcknowledge;

	@FindBy(xpath = "//div/input[@name='alert_start_date']")
	WebElement inputStartDate;

	@FindBy(xpath = "//div/input[@name='alert_end_date']")
	WebElement inputEndDate;

	@FindBy(xpath = "//a[normalize-space()='Save']")
	WebElement buttonSaveAlert;

	@FindBy(xpath = "//button[@id='alert_filter_dropdown']")
	WebElement buttonAlertFilterAndSearch;

	@FindBy(xpath = "//span[normalize-space()='Select Alert Status']")
	WebElement dropDownAlertStatusFilterAndSearch;

	@FindBy(xpath = "//div[@id='alert_status_chosen']//input[@type='text']")
	WebElement inputAlertStatus;

	@FindBy(xpath = "//button[@id='alert_filter_search']")
	WebElement buttonFilterAndSearchAlertSearch;

	@FindBy(xpath = "//*[@id='filter_alerts']/p[1]")
	WebElement resultAlertFilter;
	
	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	WebElement nameoFtheUser;
	
	@FindBy(xpath = "//div[@id='search_status_in_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputStatus;
	
	@FindBy(xpath = "//label[text()='Requestor Name']/following-sibling::input")
	WebElement inputRequestorName;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;
	
	@FindBy(xpath = "//tbody/tr")
	WebElement searchResultAfterMultipleSearch;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement openFirstSearchResultRequest;
	
	@FindBy(xpath = "//button[@id='dropdown1']")
	WebElement buttonFilterTeamPerformance;
	
	@FindBy(xpath = "//a[@class='no-wrap-id']")
	WebElement linkSearchRequestID;
	
	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;
	
	@FindBy(xpath = "//input[@id='number_of_pages']")
	WebElement inputNumberOfPages;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSaveNumberOfRecords;
	
	@FindBy(xpath = "//a[@id='generate-quote']")
	WebElement buttonSubmitToRequestor;
	
	@FindBy(xpath = "//button[@id='approve-picing-strategy-btn']")
	WebElement buttonApprovePricingStrategy;
	
	@FindBy(xpath = "//a[@id='approve-service-btn']")
	WebElement buttonApproveService;
	
	@FindBy(xpath = "//a[@id='submit-to-req-btn']")
	WebElement buttonSubmitToRequestorRequestProcessing;

	public AdminTeamLeaderHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void openTeamLeaderHomePage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		if (TestUtil.isElementDisplayed(adminDropDownTeamLeaderHomePage)) {
			wait.until(ExpectedConditions.elementToBeClickable(adminDropDownTeamLeaderHomePage));
			adminDropDownTeamLeaderHomePage.click();
			TestListener.infoMessage("Open Admin Team Leader Home Page");
			TestListener.addDynamicScreenshotInReport("OpenAdminTeamLeaderHomePage");
			wait.until(ExpectedConditions.elementToBeClickable(buttonAddGoal));
		} else {
			System.out.println("User Don't Have permission for Team Leader Home Page");
			TestListener.infoMessage("User Don't Have permission for Team Leader Home Page");
			TestListener.addDynamicScreenshotInReport("NoAccessAdminTeamLeaderHomePage");
		}
	}

	public String addGoal(boolean csa, boolean team) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddGoal));
		buttonAddGoal.click();
		wait.until(ExpectedConditions.visibilityOf(headingTitleAddGoal));
		if (csa) {
			radioButtonCSA.click();
			System.out.println("Selecting CSA User");
			TestListener.infoMessage("Selecting CSA User");
			TestListener.addDynamicScreenshotInReport("selectCSAUser");
			inputCSAUserName.click();
			inputCSAUserName.sendKeys("Custodian");
			inputCSAUserName.sendKeys(Keys.ENTER);
		} else if (team) {
			radioButtonTeam.click();
			System.out.println("Selecting Team User");
			TestListener.infoMessage("Selecting Team User");
			TestListener.addDynamicScreenshotInReport("selectTeamUser");
			inputTeamName.click();
			inputTeamName.sendKeys("Admin");
			inputTeamName.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Select The goal Type");
			TestListener.infoMessage("Select The goal Type");
			TestListener.addDynamicScreenshotInReport("selectGoalTypeUser");
		}
		inputGoalNumber.clear();
		String tempGoalNumber = TestUtil.getRandomNumericString(2);
		inputGoalNumber.sendKeys(tempGoalNumber);
		buttonSaveGoal.click();
		return tempGoalNumber;
	}

	public void GoalNumber(String GoalNumber) {
		int j = 0;
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddGoal));
		int noOfRows = driver.findElements(By.xpath("//tbody[@id='team_performance']/tr")).size();
		for (int i = 1; i <= noOfRows - 1; i++) {
			String value = driver.findElement(By.xpath("//tbody[@id='team_performance']/tr[" + i + "]/td[10]"))
					.getText();
			if (value.equals(GoalNumber)) {
				System.out.println("Value Matched");
				j = j + 1;
			} else {
				System.out.println("Value NOT-Matched");
			}
		}
		if (j == 1) {
			System.out.println(">>>>Goal Set For The CSA User<<<<");
		} else {
			System.out.println(">>>>Goal Set For The Team<<<<");
		}
	}

	public void verifyAlertCSA() {
		wait.until(ExpectedConditions.visibilityOf(buttonTabAlertCSA));
		buttonTabAlertCSA.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectAlertCSA));
		dropDownSelectAlertCSA.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputAlertCSAUserName));
		inputAlertCSAUserName.click();
		inputAlertCSAUserName.sendKeys("Admin");
		inputAlertCSAUserName.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(alertPresentCSA));
		openRejectRequest.click();
		wait.until(ExpectedConditions.visibilityOf(acknowledgmentMessage));
		String acknMessage = acknowledgmentMessage.getText();
		if (acknMessage.contains("acknowledge")) {
			System.out.println("Request Get Acknowledge");
		} else {
			System.out.println("Request NOT Get Acknowledge");
		}
		buttonCloseAlertPage.click();
	}

	public void verifyAlertTeam() {
		wait.until(ExpectedConditions.visibilityOf(buttonTabAlertCSA));
		buttonTabAlertTeam.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectAlertTeam));
		dropDownSelectAlertTeam.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputAlertTeamUserName));
		inputAlertTeamUserName.click();
		inputAlertTeamUserName.sendKeys("Admin");
		inputAlertTeamUserName.sendKeys(Keys.ENTER);
		TestUtil.hardWait(5);
		String notAlertMessage = notAlertPresentMessage.getText();
		if (notAlertMessage.contains("No Alerts")) {
			System.out.println("No Such Alert is Present");
		} else {
			openRejectRequest.click();
			wait.until(ExpectedConditions.visibilityOf(acknowledgmentMessage));
			String acknMessage = acknowledgmentMessage.getText();
			if (acknMessage.contains("acknowledge")) {
				System.out.println("Request Get Acknowledge");
			} else {
				System.out.println("Request NOT Get Acknowledge");
			}
			buttonCloseAlertPage.click();
		}
	}

	public void verifyAlertType() {
		wait.until(ExpectedConditions.visibilityOf(buttonTabAlert));
		buttonTabAlert.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectAlertType));
		dropDownSelectAlertType.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputAlertTypeUserName));
		// inputAlertTypeUserName.click();
		inputAlertTypeUserName.sendKeys("REJECTION");
		inputAlertTypeUserName.sendKeys(Keys.ENTER);
		TestUtil.hardWait(5);
		String tempURL = driver.getCurrentUrl();
		if (tempURL.contains("preproduction")) {
			openRejectRequestAlertTypePreProduction.click();
		} else {
			openRejectRequestAlertType.click();
		}
		wait.until(ExpectedConditions.visibilityOf(acknowledgmentMessage));
		String acknMessage = acknowledgmentMessage.getText();
		if (acknMessage.contains("acknowledge")) {
			System.out.println("Request Get Acknowledge");
		} else {
			System.out.println("Request NOT Get Acknowledge");
		}
		buttonCloseAlertPage.click();
	}

	public void createAlert(Boolean alertForCSAUser) {
		wait.until(ExpectedConditions.visibilityOf(buttonCreateAlert));
		buttonCreateAlert.click();
		wait.until(ExpectedConditions.elementToBeClickable(radioButtonCreateAlertTeams));
		if (alertForCSAUser) {
			radioButtonCreateAlertCSAUsers.click();
			wait.until(ExpectedConditions.visibilityOf(dropDownCreateAlertCSAUser));
			dropDownCreateAlertCSAUser.click();
			inputCreateAlertCSAName.click();
			inputCreateAlertCSAName.sendKeys("jafar");
			inputCreateAlertCSAName.sendKeys(Keys.ENTER);
		} else {
			radioButtonCreateAlertTeams.click();
			wait.until(ExpectedConditions.elementToBeClickable(dropDownCreateAlertTeam));
			dropDownCreateAlertTeam.click();
			dropDownCreateAlertTeam.click();
			dropDownCreateAlertTeam.sendKeys("Admin");
			dropDownCreateAlertTeam.sendKeys(Keys.ENTER);
		}
		wait.until(ExpectedConditions.visibilityOf(dropdowSelectPriority));
		dropdowSelectPriority.click();
		inputPriorityName.click();
		inputPriorityName.sendKeys("High");
		inputPriorityName.sendKeys(Keys.ENTER);
		textAreaAlertMessage.sendKeys("Automation Alert Creation");
		if (checkboxAcknowledge.isSelected()) {
			System.out.println("Acknowlege Already Checked");
		} else {
			checkboxAcknowledge.click();
		}
		inputStartDate.click();
		String StartDate = getTodayDate();
		driver.findElement(By.xpath("//td[normalize-space()=" + StartDate + "]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(inputEndDate));
		inputEndDate.click();
		String EndDate = getNextDate();
		driver.findElement(By.xpath("//td[normalize-space()=" + EndDate + "]")).click();
		wait.until(ExpectedConditions.visibilityOf(buttonSaveAlert));
		buttonSaveAlert.click();
	}

	public String getTodayDate() {
		DateFormat df = new SimpleDateFormat("dd");
		Date dateobj = new Date();
		System.out.println("Current Date is " + df.format(dateobj));
		System.out.println("Current Date is Formated" + df.format(dateobj).replaceFirst("^0+(?!$)", ""));
		return df.format(dateobj).replaceFirst("^0+(?!$)", "");
	}

	public static String getNextDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date currentDate = new Date();
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(1);
		Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(
				"Next Date id Formated : " + dateFormat.format(currentDatePlusOneDay).replaceFirst("^0+(?!$)", ""));
		return dateFormat.format(currentDatePlusOneDay).replaceFirst("^0+(?!$)", "");
	}

	public void filterAndSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonAlertFilterAndSearch));
		buttonAlertFilterAndSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownAlertStatusFilterAndSearch));
		dropDownAlertStatusFilterAndSearch.click();
		inputAlertStatus.click();
		inputAlertStatus.sendKeys("Read");
		inputAlertStatus.sendKeys(Keys.ENTER);
		buttonFilterAndSearchAlertSearch.click();
		wait.until(ExpectedConditions.visibilityOf(resultAlertFilter));
		if (TestUtil.isElementDisplayed(resultAlertFilter)) {
			System.out.println("Filter Works Properly");
			TestListener.infoMessage("Filter Works Properly");
			TestListener.addDynamicScreenshotInReport("FilterWorksProperly");
		} else {
			System.out.println("Filter NOT-Works Properly");
			TestListener.infoMessage("Filter NOT-Works Properly");
			TestListener.addDynamicScreenshotInReport("FilterNOTWorksProperly");
		}
	}

	public void moveRequestFromProcessingToPriced(String statusType, String RequestorName) {

		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputStatus));
			inputStatus.click();
			inputStatus.sendKeys(statusType);
			inputStatus.sendKeys(Keys.ENTER);
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(inputStatus));
			inputStatus.click();
			inputStatus.sendKeys(statusType);
			inputStatus.sendKeys(Keys.ENTER);
		}
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorName));
		inputRequestorName.click();
		inputRequestorName.sendKeys(RequestorName);
		inputRequestorName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultAfterMultipleSearch));
		//Open The First Request
		openFirstSearchResultRequest.click();
	}
	
	public void verifyGoalNumberRequestChange() {
		int j = 0;
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterTeamPerformance));
		int noOfRows = driver.findElements(By.xpath("//tbody[@id='team_performance']/tr")).size();
		for (int i = 1; i <= noOfRows - 1; i++) {
			String value = driver.findElement(By.xpath("//tbody[@id='team_performance']/tr[" + i + "]/td[11]"))
					.getText().replaceAll(" Details", "");
			if (!value.contains("0.0")) {
				System.out.println("Value Changed");
				TestListener.infoMessage("Value Changed");
				TestListener.addDynamicScreenshotInReport("ValueChanged"+i);
				j = j + 1;
			} else {
				System.out.println("Value NOT-Changed");
				TestListener.infoMessage("Value NOT-Changed");
				TestListener.addDynamicScreenshotInReport("ValueNotChanged"+i);
			}
		}
		if (j == 1) {
			System.out.println(">>>>Actual Goal Value Changed<<<<");
			TestListener.infoMessage(">>>>Actual Goal Value Changed<<<<");
		} else {
			System.out.println(">>>>Actual Goal Value NOT-Changed<<<<");
			TestListener.infoMessage(">>>>Actual Goal Value NOT-Changed<<<<");
		}		
	}
	
	public void requestFulfillment() {
		js.executeScript("arguments[0].click();", linkSearchRequestID);
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(inputNumberOfPages));
		inputNumberOfPages.sendKeys("5");
		js.executeScript("arguments[0].click();", buttonSaveNumberOfRecords);
		//buttonSaveNumberOfRecords.click();
		TestUtil.hardWait(5);
		js.executeScript("arguments[0].click();", buttonSubmitToRequestor);
		TestUtil.hardWait(10);
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
}
