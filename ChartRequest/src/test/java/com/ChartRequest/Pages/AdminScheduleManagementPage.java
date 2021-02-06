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
import com.ChartRequest.Utility.TestUtil;

public class AdminScheduleManagementPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
	JavascriptExecutor jse = (JavascriptExecutor)driver;


	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//li//a[contains(text(),'[adm] Schedule Management')]")
	WebElement adminDropDownAdminScheduleManagement;

	@FindBy(xpath = "//select[@id='team_name']")
	WebElement dropdownSelectTeam;

	@FindBy(xpath = "//div[contains(text(),'Edit Schedule for')]")
	WebElement headingVerify;

	@FindBy(xpath = "//*[@name='user_schedule[start_time]']")
	WebElement inputStartTime;

	@FindBy(xpath = "//*[@name='user_schedule[end_time]']")
	WebElement inputEndTime;
	
	@FindBy(xpath = "//label[normalize-space()='Rolling Shift']")
	WebElement checkboxRollingShift;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSave;
	
	@FindBy(xpath = "//option[contains(text(),'America/New York')]")
	WebElement dropDownValueAmericaNewYork;
	
	@FindBy(xpath = "//option[contains(text(),'India/Delhi')]")
	WebElement dropDownValueIndiaNewDelhi;
	
	//@FindBy(xpath="//strong[contains(text(),'SUN')]/following::tbody/tr/td[2]")
	@FindBy(xpath = "//strong[contains(text(),'SUN')]/following::tbody/tr/td[2]/div/div/div[@class='rightschtxt']/a")
	WebElement addShiftTime;
	
	@FindBy(xpath = "//strong[contains(text(),'MON')]/following::tbody/tr/td[3]")
	WebElement addShiftTimeMonday;
	
	@FindBy(xpath = "//label[@for='user_schedule_sunday']")
	WebElement labelSundayAddShift;
	
	@FindBy(xpath = "//label[normalize-space()='M']")
	WebElement labelMondayAddShift;
	
	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	WebElement buttonDeleteShiftTime;
	
	@FindBy(xpath = "//div[@class='scheditpopbody']/div/a[@data-method='delete']")
	WebElement buttonYesConfrimDeleteButton;

	public AdminScheduleManagementPage() {
		PageFactory.initElements(driver, this);
	}

	public void openAdminScheduleManagementPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownAdminScheduleManagement));
		adminDropDownAdminScheduleManagement.click();
		System.out.println("Open Admin Schedule Management Page");
		TestListener.infoMessage("Open Admin Schedule Management Page");
		TestListener.addDynamicScreenshotInReport("OpenAdminScheduleManagementPage");
		wait.until(ExpectedConditions.elementToBeClickable(dropdownSelectTeam));
	}

	public void selectTeam(String TeamName) {
		Select selectSize = new Select(driver.findElement(By.name("team_name")));
		selectSize.selectByVisibleText(TeamName);
		TestListener.infoMessage("Select the team from the drop down "+TeamName);
		TestListener.addDynamicScreenshotInReport("SelectTheTeam");
	}

	public void changeShiftTime(String TeamName) {
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//span[contains(text(),'" + TeamName + "')]/following::img[@alt='Edit'][1]")).click();
		wait.until(ExpectedConditions.visibilityOf(headingVerify));
		//Change the Start Time
		inputStartTime.click();
		for (int i = 1; i <= 7; i++) {
			inputStartTime.sendKeys(Keys.BACK_SPACE);			
		}
		inputStartTime.sendKeys("1");
		inputStartTime.sendKeys("4");
		inputStartTime.sendKeys(":");
		inputStartTime.sendKeys("0");
		inputStartTime.sendKeys("0");
		inputStartTime.sendKeys(Keys.TAB);
		
		//Change the End Time
		inputStartTime.click();
		for (int i = 1; i <= 7; i++) {
			inputEndTime.sendKeys(Keys.BACK_SPACE);			
		}
		inputEndTime.sendKeys("1");
		inputEndTime.sendKeys("5");
		inputEndTime.sendKeys(":");
		inputEndTime.sendKeys("0");
		inputEndTime.sendKeys("0");
		inputEndTime.sendKeys(Keys.TAB);
		TestListener.infoMessage("Change in Shift Timing");
		TestListener.addDynamicScreenshotInReport("ShiftTimeChange");		
		checkboxRollingShift.click();
		buttonSave.click();
		TestListener.addDynamicScreenshotInReport("ShiftTimeChanged");		
	}
	
	public void changeTimeZone() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownValueAmericaNewYork));
		Select selectSize = new Select(driver.findElement(By.name("time_zone")));
		String timeZoneValue=dropDownValueAmericaNewYork.getText();
		if (timeZoneValue.contains("America")) {
			selectSize.selectByVisibleText("India/Delhi");
			System.out.println("Time Zone Changed to India/Delhi");
			TestListener.infoMessage("Time Zone Changed to India/Delhi");
		} else {
			selectSize.selectByVisibleText("America/New York");
			System.out.println("Time Zone Changed to America/New York");
			TestListener.infoMessage("Time Zone Changed to America/New York");
		}
		TestListener.infoMessage("Time Zone Changed");
		TestListener.addDynamicScreenshotInReport("TimeZoneChanged");
	}
	
	public void deleteShiftTiming(String TeamName) {
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//span[contains(text(),'" + TeamName + "')]/following::img[@alt='Edit'][1]")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteShiftTime));
		buttonDeleteShiftTime.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonYesConfrimDeleteButton));
		buttonYesConfrimDeleteButton.click();
		TestListener.infoMessage("Shift Time Deleted");
		TestListener.addDynamicScreenshotInReport("ShiftTimeDeleted");
		System.out.println("Shift Time Deleted");
	}
	
	public void addShift(String TeamName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(addShiftTime));
		addShiftTime.click();
		//wait.until(ExpectedConditions.elementToBeClickable(labelSundayAddShift));
		//labelSundayAddShift.click();
		TestUtil.hardWait(3);
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(dropDownValueAmericaNewYork));
		TestListener.infoMessage("Shift Time Added");
		TestListener.addDynamicScreenshotInReport("ShiftTimeAdded");
		System.out.println("Shift Time Added");
		//deleteShiftTiming(TeamName);
	}
	
	public void addShiftMonday(String TeamName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(addShiftTimeMonday));
		addShiftTimeMonday.click();
		wait.until(ExpectedConditions.elementToBeClickable(labelMondayAddShift));
		labelMondayAddShift.click();
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(dropDownValueAmericaNewYork));
		TestListener.infoMessage("Shift Time Added");
		TestListener.addDynamicScreenshotInReport("ShiftTimeAdded");
		System.out.println("Shift Time Added");
		deleteShiftTiming(TeamName);
	}
}