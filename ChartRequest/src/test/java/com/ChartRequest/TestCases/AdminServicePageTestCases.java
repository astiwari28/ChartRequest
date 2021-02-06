package com.ChartRequest.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminServicePage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SetupAndPolicyPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class AdminServicePageTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminServicePage adminServicePage;
	CreateRequest createRequest;
	CustodianStatement custodianStatement;
	CustodianStatement_Old custodianStatement_Old;
	SetupAndPolicyPage setupAndPolicyPage;
	SearchMyRequest searchMyRequest;
	
	public AdminServicePageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		createRequest=new CreateRequest();
		adminServicePage=new AdminServicePage();
		custodianStatement = new CustodianStatement();
		custodianStatement_Old = new CustodianStatement_Old();
		setupAndPolicyPage = new SetupAndPolicyPage();
		searchMyRequest=new SearchMyRequest();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
	}
	
	@Test(priority = 1, enabled = true)
	private void resetPrices() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement_Old.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			setupAndPolicyPage.openEditServiceAndPolicyPage();
			setupAndPolicyPage.changePrice(" ", " ", " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, enabled = true, dependsOnMethods = "resetPrices")
	public void setNewPriceForFaxService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newTempPrice=adminServicePage.setAndGetPriceForFaxService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyFaxReturnPrice(newTempPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = true)
	public void setNewPriceForRushRequestService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newTempPrice=adminServicePage.setAndGetPriceForRushRequestService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyRushRequestPrice(newTempPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4, enabled = true)
	public void setNewPriceForAffidavitService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForAffidavitService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyAffidavitPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5, enabled = true)
	public void setNewPriceForArchivedRecordsSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForArchivedRecordsSearchService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyArchivedRecordsPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6, enabled = true)
	public void setNewPriceForNotarizeRecordsSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForNotarizeRecordsSearchService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyNotarizeRecordsPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7, enabled = true)
	public void setNewPriceForRecordCertificationSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForRecordCertificationSearchService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyRecordCertificationPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void setNewPriceForDisabilityFormSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForDisabilityFormSearchService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyDisabilityFormPrice(newPrice);	
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 10, enabled = true)
	public void setNewPriceForPayByCheckSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForPayByCheckSearchService();
			loginpage.logout();
			/*loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 10, enabled = true)
	public void setNewPriceForMedicalImagesSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForMedicalImagesService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyMedicalImagePrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 11, enabled = true)
	public void setNewPriceForRetrievalSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForRetrievalService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyRetrievalServicePrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 12, enabled = true)
	public void setNewPriceForDepositionFormsSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForDepositionFormsService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyDepositionFormsPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 13, enabled = true)
	public void setNewPriceForWitnessFeeSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForWitnessFeeService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyWitnessFeePrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 14, enabled = true)
	public void setNewPriceForFilmBreakdownSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForFilmBreakdownService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyFilmBreakdownPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 15, enabled = true)
	public void setNewPriceForStorageFeePatientsSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForStorageFeePatientsService();
			loginpage.logout();
			/*loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 16, enabled = true)
	public void setNewPriceForPostageSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForPostageService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyPostagePrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 17, enabled = true)
	public void setNewPriceForFMLAFormSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForFMLAFormService();
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			adminServicePage.verifyFMLAFormPrice(newPrice);
			createRequest.abandonRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 18, enabled = true)
	public void setNewPriceForBaseLaborRateSearchService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			String newPrice=adminServicePage.setAndGetPriceForBaseLaborRateService();
			loginpage.logout();
			/*loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 19, enabled = true)
	public void addNewAuthorizationBuilder() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminAuthorizationBuilderTab();
			String tempAuthorizationName=adminServicePage.addNewAuthorizationBuilder("IN");
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
					"Medical", false, tempAuthorizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 20, enabled = true)
	public void addRetrievalDocument() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			adminServicePage.openTabRetrievalPacketBuilder();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			TestUtil.hardWait(5);
			searchMyRequest.DynmaicLastPage();
			String RequestID = createRequest.getRequestID();
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			driver.findElement(By.xpath("//a[contains(normalize-space(),'"+RequestID+"')]")).click();
			TestUtil.hardWait(5);
			adminServicePage.processingRequest();
			adminServicePage.verifyRetrievalPacketBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 21, enabled = true)
	public void verifyServiceNameWithMobileServiceTab() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			List<String> serviceName=adminServicePage.getServiceNameList();
			List<String> mobileTabServiceName=adminServicePage.getServiceListTabMobileService();
			for (String string : serviceName) {
				for (String value : mobileTabServiceName) {
					if (value.contains(string)) {
						System.out.println("->Value Found "+value);
						TestListener.infoMessage("Value of Service "+value+" Found "+string);
						break;
					} else {
						System.out.println("!!Value NOT-Found "+value);
						TestListener.infoMessage("Value of Service "+value+" Found "+string);
						continue;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 22, enabled = true)
	public void verifyServiceNameWithRequestCreation() {
		try {
			int j=0;
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminServicePage.openAdminServicePage();
			List<String> serviceName=adminServicePage.getServiceNameList();
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			List<String> requestPageServiceList=adminServicePage.getServiceListFromRequest();
			for (String string : serviceName) {
				for (String value : requestPageServiceList) {
					if (value.contains(string)) {
						j=1;
						System.out.println("->Value of Service "+value+" Found "+string);
						TestListener.infoMessage("Value of Service "+value+" Found "+string);
						break;
					} else {
						System.out.println("!!Value of Service "+value+" NOT-Found "+string);
						TestListener.infoMessageFail("Value of Service "+value+" NOT-Found "+string);
						continue;
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
