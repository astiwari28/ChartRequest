package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminDashboardPage extends BrowserConfiguration{

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AdminDashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[@href='/company/dashboards']")
	WebElement adminDashboardPage;
	
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	WebElement headingDashboard;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12:nth-child(1) div.row-fluid.spans-with-separator:nth-child(2) div.col-sm-4.col-xs-12:nth-child(1) > h1:nth-child(4)")
	WebElement valueRequestProcessed;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12:nth-child(1) div.row-fluid.spans-with-separator:nth-child(2) div.col-sm-4.col-xs-12:nth-child(2) > h1:nth-child(4)")
	WebElement valuePricedAndUnpaidRequests;

	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12:nth-child(1) div.row-fluid.spans-with-separator:nth-child(2) div.col-sm-4.col-xs-12:nth-child(3) > h1:nth-child(4)")
	WebElement valueAverageNewRequestsPerDay;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(4) div.col-sm-4.col-xs-12:nth-child(1) > h1:nth-child(4)")
	WebElement value90DayTurnAroundTime;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(4) div.col-sm-4.col-xs-12:nth-child(2) > h1:nth-child(4)")
	WebElement value30DayTurnAroundTime;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(4) div.col-sm-4.col-xs-12:nth-child(3) > h1:nth-child(4)")
	WebElement value7DayTurnAroundTime;

	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(6) div.col-sm-4.col-xs-12:nth-child(1) > h1:nth-child(4)")
	WebElement value90DayTurnAroundTimeFullService;

	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(6) div.col-sm-4.col-xs-12:nth-child(2) > h1:nth-child(4)")
	WebElement value30DayTurnAroundTimeFullService;

	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11.col-xs-12.mb15:nth-child(2) div.row-fluid.spans-with-separator:nth-child(6) div.col-sm-4.col-xs-12:nth-child(3) > h1:nth-child(4)")
	WebElement value7DayTurnAroundTimeFullService;
	
	@FindBy(css = "body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11:nth-child(4) div:nth-child(1) svg:nth-child(1) g:nth-child(3) g:nth-child(3) > circle:nth-child(1)")
	WebElement graphValue;
	
	@FindBy(xpath = "//button[normalize-space()='Month']")
	WebElement buttonMonth;

	
	public void openAdminDashboardPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(adminDashboardPage));
		adminDashboardPage.click();
		TestListener.infoMessage("Open Admin Dashboard Page");
		wait.until(ExpectedConditions.visibilityOf(headingDashboard));
	}
	
	public void getRequestsProcessed() {
		wait.until(ExpectedConditions.visibilityOf(valueRequestProcessed));
		String tempValue=valueRequestProcessed.getText();
		int i=convertStringToint(tempValue);
		if (i>0) {
			System.out.println("Value of Request Processed is "+tempValue);
			TestListener.infoMessage("Value of Request Processed is "+tempValue);
		} else {
			System.out.println("Value of Request Processed is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of Request Processed is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("getRequestsProcessed");
		}
	}
	
	public void getPricedAndUnpaidRequests() {
		wait.until(ExpectedConditions.visibilityOf(valuePricedAndUnpaidRequests));
		String tempValue=valuePricedAndUnpaidRequests.getText();
		int i=convertStringToint(tempValue);
		if (i>0) {
			System.out.println("Value of Priced And Unpaid Requests is "+tempValue);
			TestListener.infoMessage("Value of Priced And Unpaid Requests is "+tempValue);
		} else {
			System.out.println("Value of Priced And Unpaid Requests is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of Priced And Unpaid Requests is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("getPricedAndUnpaidRequests");
		}
	}
	
	public void getAverageNewRequestsPerDay() {
		wait.until(ExpectedConditions.visibilityOf(valueAverageNewRequestsPerDay));
		String tempValue=valueAverageNewRequestsPerDay.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of Average New Requests Per Day is "+tempValue);
			TestListener.infoMessage("Value of Average New Requests Per Day is "+tempValue);
		} else {
			System.out.println("Value of Average New Requests Per Day is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of Average New Requests Per Day is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("getAverageNewRequestsPerDay");
		}
	}

	public void get90DayTurnAroundTime() {
		wait.until(ExpectedConditions.visibilityOf(value90DayTurnAroundTime));
		String tempValue=value90DayTurnAroundTime.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 90-Day Turn Around Time is "+tempValue);
			TestListener.infoMessage("Value of 90-Day Turn Around Time is "+tempValue);
		} else {
			System.out.println("Value of 90-Day Turn Around Time is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of 90-Day Turn Around Time is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get90DayTurnAroundTime");
		}
	}
	
	public void get30DayTurnAroundTime() {
		wait.until(ExpectedConditions.visibilityOf(value30DayTurnAroundTime));
		String tempValue=value30DayTurnAroundTime.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 30-Day Turn Around Time is "+tempValue);
			TestListener.infoMessage("Value of 30-Day Turn Around Time is "+tempValue);
		} else {
			System.out.println("Value of 30-Day Turn Around Time is Less Than ZERO "+tempValue);			
			TestListener.infoMessageFail("Value of 30-Day Turn Around Time is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get30DayTurnAroundTime");
		}
	}
	
	public void get7DayTurnAroundTime() {
		wait.until(ExpectedConditions.visibilityOf(value7DayTurnAroundTime));
		String tempValue=value7DayTurnAroundTime.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 7-Day Turn Around Time is "+tempValue);
			TestListener.infoMessage("Value of 7-Day Turn Around Time is "+tempValue);
		} else {
			System.out.println("Value of 7-Day Turn Around Time is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of 7-Day Turn Around Time is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get7DayTurnAroundTime");
		}
	}
	
	public void get90DayTurnAroundTimeFullService() {
		wait.until(ExpectedConditions.visibilityOf(value90DayTurnAroundTimeFullService));
		String tempValue=value90DayTurnAroundTimeFullService.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 90-Day Turn Around Time Full Service is "+tempValue);
			TestListener.infoMessage("Value of 90-Day Turn Around Time Full Service is "+tempValue);
		} else {
			System.out.println("Value of 90-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of 90-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get90DayTurnAroundTimeFullService");
		}
	}
	
	public void get30DayTurnAroundTimeFullService() {
		wait.until(ExpectedConditions.visibilityOf(value30DayTurnAroundTimeFullService));
		String tempValue=value30DayTurnAroundTimeFullService.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 30-Day Turn Around Time Full Service is "+tempValue);
			TestListener.infoMessage("Value of 30-Day Turn Around Time Full Service is "+tempValue);
		} else {
			System.out.println("Value of 30-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of 30-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get30DayTurnAroundTimeFullService");
		}
	}
	
	public void get7DayTurnAroundTimeFullService() {
		wait.until(ExpectedConditions.visibilityOf(value7DayTurnAroundTimeFullService));
		String tempValue=value7DayTurnAroundTimeFullService.getText();
		float i=convertStringToFloat(tempValue);
		if (i>0.0) {
			System.out.println("Value of 7-Day Turn Around Time Full Service is "+tempValue);
			TestListener.infoMessage("Value of 7-Day Turn Around Time Full Service is "+tempValue);
		} else {
			System.out.println("Value of 7-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.infoMessageFail("Value of 7-Day Turn Around Time Full Service is Less Than ZERO "+tempValue);
			TestListener.addDynamicScreenshotInReport("get7DayTurnAroundTimeFullService");
		}
	}
	
	public void getValuefromGraph(String ChartType) {
		wait.until(ExpectedConditions.visibilityOf(graphValue));
		selectChartType(ChartType);
		TestListener.infoMessage("Open the Chart Type "+ChartType);
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.elementToBeClickable(buttonMonth));
		buttonMonth.click();
		TestUtil.hardWait(3);
		Actions actions =new Actions(driver);
		int noOfValue=driver.findElements(By.xpath("//*[name()='g' and contains(@clip-path,'url(https:')]/following-sibling::*[1]/*")).size();
		for (int i = 1; i <=noOfValue; i++) {
			//actions.moveToElement(graphValue).perform();
			actions.moveToElement(driver.findElement(By.cssSelector("body.spu_user.company.dashboards.index:nth-child(2) div.container.increase_width_of_legacy:nth-child(7) div.sheet:nth-child(4) div.inner div.row:nth-child(1) div.col-sm-11:nth-child(4) div:nth-child(1) svg:nth-child(1) g:nth-child(3) g:nth-child(3) > circle:nth-child("+i+")"))).perform();
			String tempValue=driver.findElement(By.xpath("//*[contains(text(),'Value:')]/following-sibling::*")).getText();
			//String tempValue=graphValue.getText();
			System.out.println("Value of Graph is "+tempValue);
			float convertValue=convertStringToFloat(tempValue);
			if (convertValue>0.0) {
				System.out.println("Value of Graph is "+tempValue);
				TestListener.infoMessage("Value of Graph is "+tempValue);
			} else {
				System.out.println("Value of Graph is Less Than ZERO "+tempValue);
				TestListener.infoMessageFail("Value of Graph is Less Than ZERO "+tempValue);
				TestListener.addDynamicScreenshotInReport("getValuefromGraph");
			}
		}
		
	}
	
	public void selectChartType(String ChartType) {
		Select chartType = new Select(driver.findElement(By.name("chart_type")));
		chartType.selectByVisibleText(ChartType);

	}
	
	public int convertStringToint(String inputStringForInterger) {
		return Integer.parseInt(inputStringForInterger);  
	}
	
	public float convertStringToFloat(String inputStringForFloat) {
		return Float.parseFloat(inputStringForFloat);  
	}
}
