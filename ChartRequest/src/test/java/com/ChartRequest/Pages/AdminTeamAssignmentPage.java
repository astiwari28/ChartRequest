package com.ChartRequest.Pages;

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

public class AdminTeamAssignmentPage extends BrowserConfiguration{

	WebDriverWait wait =new WebDriverWait(driver, 30);

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;
	
	//@FindBy(xpath = "//li//a[contains(text(),'[adm] Team Assignment')]")
	@FindBy(xpath = "//a[@href='/company/teams']")
	WebElement adminDropDownTeamAssignmentPage;
	
	@FindBy(xpath = "//a[normalize-space()='Create Team']")
	WebElement buttonCreateTeam;
	
	@FindBy(xpath = "//input[@id='team_team_name']")
	WebElement inputTeamName;
	
	@FindBy(xpath = "//span[@class='slider round']")
	WebElement sliderIncludeTeamInProductivityReporting;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement buttonSaveTeamAssignmentPage;
	
	@FindBy(xpath = "//div[@id='notice']")
	WebElement confrimationMessage;
	
	@FindBy(xpath = "//table[@class='main-table']/tbody/tr/td[contains(text(),'Automation Testing')]/following::td[1]/div/div/div/a/span")
	WebElement editIconNoTeamMemberAssigned;
	
	@FindBy(xpath = "//a[normalize-space()='Delete Team']")
	WebElement buttonDeleteTeam;
	
	@FindBy(xpath = "//input[@id='user_name']")
	WebElement searchInputUser;
	
	@FindBy(xpath = "//a[normalize-space()='Search']")
	WebElement buttonSearchEditTeamMember;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement buttonAddEditTeamMember;
	
	@FindBy(xpath = "//a[@class='chosen-single']//span")
	WebElement getUserTopNameDropDown;
	
	@FindBy(xpath = "//div[@class='alert alert-info']//strong")
	WebElement teamLeaderConfrimationMessage;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement buttonCloseAddTeamLeaderPage;
	
	@FindBy(xpath = "//table[@class='main-table']/tbody/tr/td[contains(text(),'Automation')]/following::td[2]/div/div/div/a/span")
	WebElement editIconNoViewAssignedCustodian;
	
	@FindBy(xpath = "//div[@id='custodian_id_chosen']//span")
	WebElement dropDownSelectCustodian;
	
	@FindBy(xpath = "//*[@id='requestor_id_chosen']/a/span")
	WebElement dropDownSelectRequestor;
	
	@FindBy(xpath = "//div[@id='custodian_id_chosen']//input[@type='text']")
	WebElement inputCustodianName;
	
	@FindBy(xpath = "//div[@id='requestor_id_chosen']//input[@type='text']")
	WebElement inputRequestorName;
	
	@FindBy(xpath = "//div[@id='custodian']//button[@class='btn btn-primary'][normalize-space()='Add']")
	WebElement buttonAdd;
	
	@FindBy(xpath = "//div[@id='user_team_msg_Custodian']//strong")
	WebElement confrimMessageHeading;
	
	@FindBy(xpath = "//input[@id='team_organization_type_custodian']")
	WebElement radioButtonOrganizationTypeCustodian;

	@FindBy(xpath = "//input[@id='team_organization_type_requestor']")
	WebElement radioButtonOrganizationTypeRequestor;

	@FindBy(xpath = "//*[@id='custodian_teams']")
	WebElement tabName;
	
	
	public AdminTeamAssignmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void openAdminTeamAssigmentPage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownTeamAssignmentPage));
		adminDropDownTeamAssignmentPage.click();
		//TestListener.infoMessage("Open Admin Team Assignment Page");
		//TestListener.addDynamicScreenshotInReport("OpenAdminTeamAssigmentPage");
		wait.until(ExpectedConditions.elementToBeClickable(buttonCreateTeam));
	}
	
	public void createTeamName(boolean organziationTypeCustodian) {
		System.out.println("Create Team Name");
		wait.until(ExpectedConditions.elementToBeClickable(buttonCreateTeam));
		buttonCreateTeam.click();
		wait.until(ExpectedConditions.visibilityOf(inputTeamName));
		inputTeamName.sendKeys("Automation Testing");
		if (organziationTypeCustodian) {
			radioButtonOrganizationTypeCustodian.click();
		} else {
			radioButtonOrganizationTypeRequestor.click();
		}
		sliderIncludeTeamInProductivityReporting.click();
		//TestListener.infoMessage("Creating New Team");
		//TestListener.addDynamicScreenshotInReport("CreateNewTeam");
		wait.until(ExpectedConditions.elementToBeClickable(buttonSaveTeamAssignmentPage));
		buttonSaveTeamAssignmentPage.click();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		//TestListener.addDynamicScreenshotInReport("CreateNewTeamSuccess");
	}
	
	public void deleteTeam() {
		wait.until(ExpectedConditions.elementToBeClickable(editIconNoTeamMemberAssigned));
		editIconNoTeamMemberAssigned.click();
		wait.until(ExpectedConditions.visibilityOf(buttonDeleteTeam));
		buttonDeleteTeam.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		String tempConfrimationMessage=confrimationMessage.getText();
		if (tempConfrimationMessage.contains("Team was successfully Deleted")) {
			System.out.println("Team Successfully Deteled");
			//TestListener.infoMessage("Team Successfully Deleted");
		} else {
			System.out.println("Team Un-Successfully Deteled");
			//TestListener.infoMessage("Team Un-Successfully Deleted");

		}
	}
	
	public void addAndViewTeamMember() {
		wait.until(ExpectedConditions.elementToBeClickable(editIconNoTeamMemberAssigned));
		editIconNoTeamMemberAssigned.click();
		wait.until(ExpectedConditions.elementToBeClickable(searchInputUser));
		String tempURL=driver.getCurrentUrl();		
		if (tempURL.contains("preproduction")) {
			searchInputUser.sendKeys("test");
		} else {
			//searchInputUser.sendKeys("custodian.automation@test.com");
			searchInputUser.sendKeys("Cus");
		}
		
		buttonSearchEditTeamMember.click();
		String tempGetName=getUserTopNameDropDown.getText();
		buttonAddEditTeamMember.click();
		System.out.println("User Name is:- "+tempGetName);
		//TestListener.infoMessage("User Name is:- "+tempGetName);
		System.out.println("Adding Team Member in Team");
		driver.findElement(By.xpath("//td[contains(text(),'"+tempGetName+"')]/following-sibling::td[@class='team-leader-checkbox']/input")).click();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(teamLeaderConfrimationMessage));
		String tempMessage=teamLeaderConfrimationMessage.getText();
		System.out.println("Message is "+tempMessage);
		if (TestUtil.isElementDisplayed(teamLeaderConfrimationMessage)) {
			if (tempMessage.contains("Team Leader is set for this team")) {
				System.out.println("Team Leader is Set for this team");
				//TestListener.infoMessage("Team Leader is Set for this team");		
				//TestListener.addDynamicScreenshotInReport("teamLeaderAdded");
			} else {
				System.out.println("Team Leader NOT Set for this team");
				//TestListener.infoMessage("Team Leader NOT Set for this team");
				//TestListener.addDynamicScreenshotInReport("teamLeaderAddedUnSuccessfully");

			}
		} else {
			System.out.println("Custodian Not Added into the List");
			//TestListener.infoMessageFail("Custodian Not Added into the List");
			//TestListener.addDynamicScreenshotInReport("teamLeaderNotAdded");
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonCloseAddTeamLeaderPage));
		buttonCloseAddTeamLeaderPage.click();
		wait.until(ExpectedConditions.visibilityOf(buttonCreateTeam));
	}
	
	public void addAndViewCustodian() {
		wait.until(ExpectedConditions.elementToBeClickable(editIconNoViewAssignedCustodian));
		editIconNoViewAssignedCustodian.click();
		TestUtil.hardWait(3);
		String tempTabName=tabName.getText();
		//Select the User According to Custodian or Requestor
		if (tempTabName.equalsIgnoreCase("Custodian")) {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectCustodian));
		dropDownSelectCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		inputCustodianName.click();
		//inputCustodianName.sendKeys("Automation Testing");
		inputCustodianName.sendKeys("nitin");
		inputCustodianName.sendKeys(Keys.ENTER);
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectRequestor));
			dropDownSelectRequestor.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputRequestorName));
			inputRequestorName.click();
			//inputCustodianName.sendKeys("Automation Testing");
			inputRequestorName.sendKeys("ABBBBB");
			inputRequestorName.sendKeys(Keys.ENTER);
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
		buttonAdd.click();
		/*TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(confrimMessageHeading));
		if (TestUtil.isElementDisplayed(confrimMessageHeading)) {
			String tempMessage=confrimMessageHeading.getText();
			if (tempMessage.contains("Custodian successfully Added in team")) {
				System.out.println("Custodian Added Successfully");
				//TestListener.infoMessage("Custodian Added Successfully");
				//TestListener.addDynamicScreenshotInReport("CustodianAdded");
			} else {
				System.out.println("Custodian NOT-Added Successfully");
				//TestListener.infoMessage("Custodian NOT-Added Successfully");
				//TestListener.addDynamicScreenshotInReport("CustodianAddedUnSuccessfully");
			}
		} else {
			System.out.println("Custodian Not Added into the List");
			//TestListener.infoMessageFail("Custodian Not Added into the List");
			//TestListener.addDynamicScreenshotInReport("CustodianNotAdded");
		}*/
		wait.until(ExpectedConditions.elementToBeClickable(buttonCloseAddTeamLeaderPage));
		buttonCloseAddTeamLeaderPage.click();
		wait.until(ExpectedConditions.visibilityOf(buttonCreateTeam));
	}
	
	public void selectCustodianName(String assignCustodianName) {
		Select selectSize = new Select(driver.findElement(By.name("custodian_id")));
		selectSize.selectByVisibleText(assignCustodianName);
	}
	
	public boolean verifyTeamCreated(String teamName) {
		boolean flag=false;
		TestUtil.hardWait(3);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[normalize-space()='"+teamName+"']"))));
		WebElement tempWebElement=driver.findElement(By.xpath("//td[normalize-space()='"+teamName+"']"));
		boolean status=TestUtil.isElementDisplayed(tempWebElement);
		if (status) {
			System.out.println("Team is Already Created "+teamName);
			//TestListener.infoMessage("Team is Already Created "+teamName);
			flag=true;
		}
		else {
			System.out.println("Team is NOT-Created "+teamName);
			//TestListener.infoMessageFail("Team is NOT-Created "+teamName);			
			flag=false;
		}
		System.out.println("Status of Flag:- "+flag);
		return flag;
	}

}
