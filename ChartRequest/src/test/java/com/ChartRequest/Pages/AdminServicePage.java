package com.ChartRequest.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminServicePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] Services')]")
	WebElement adminDropDownServicesPage;

	@FindBy(xpath = "//li[@class='active']//a[contains(normalize-space(),'Services')]")
	WebElement servicesTab;

	@FindBy(xpath = "//a[contains(normalize-space(),'Authorization Builder')]")
	WebElement AuthorizationBuilderTab;

	@FindBy(xpath = "//dt[contains(text(),'Fax Return')]/following::dd/input[@id='fax_return']")
	WebElement getFaxPrice;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSave;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement savedMessage;

	@FindBy(xpath = "//ul[@class='services-list delivery']//li[2]")
	WebElement FaxReturnPrice;

	@FindBy(xpath = "//dt[contains(text(),'Rush Request')]/following::dd/input[@id='rush_request']")
	WebElement getRushRequestPrice;

	@FindBy(xpath = "//dt[contains(text(),'Affidavit')]/following::dd/input[@id='affidavit']")
	WebElement getAffidavitPrice;

	@FindBy(xpath = "//dt[contains(text(),'Archived Records Search')]/following::dd/input[@id='archived_records_search']")
	WebElement getArchivedRecordsSearchPrice;

	@FindBy(xpath = "//dt[contains(text(),'Notarize Records')]/following::dd/input[@id='notarize_records']")
	WebElement getNotarizeRecordsPrice;

	@FindBy(xpath = "//dt[contains(text(),'Record Certification')]/following::dd/input[@id='record_certification']")
	WebElement getRecordCertificationPrice;

	@FindBy(xpath = "//dt[contains(text(),'Disability Form')]/following::dd/input[@id='disability_form']")
	WebElement getDisabilityFormPrice;

	@FindBy(xpath = "//dt[contains(text(),'Pay By Check')]/following::dd/input[@id='pay_by_check']")
	WebElement getPayByCheckPrice;

	@FindBy(xpath = "//dt[contains(text(),'Medical Images')]/following::dd/input[@id='medical_images']")
	WebElement getMedicalImagesPrice;

	@FindBy(xpath = "//dt[contains(text(),'Retrieval Service')]/following::dd/input[@id='retrieval_service']")
	WebElement getRetrievalServicePrice;

	@FindBy(xpath = "//dt[contains(text(),'Deposition Forms')]/following::dd/input[@id='deposition_forms']")
	WebElement getDepositionFormsPrice;

	@FindBy(xpath = "//dt[contains(text(),'Witness Fee')]/following::dd/input[@id='witness_fee']")
	WebElement getWitnessFeePrice;

	@FindBy(xpath = "//dt[contains(text(),'Film Breakdown')]/following::dd/input[@id='film_breakdown']")
	WebElement getFilmBreakdownPrice;

	@FindBy(xpath = "//dt[contains(text(),'Storage Fee - Patients')]/following::dd/input[@id='storage_fee_patients']")
	WebElement getStorageFeePatientsPrice;

	@FindBy(xpath = "//dt[contains(text(),'Postage')]/following::dd/input[@id='postage']")
	WebElement getPostagePrice;

	@FindBy(xpath = "//dt[contains(text(),'FMLA Form(s)')]/following::dd/input[@id='fmla_forms']")
	WebElement getFMLAFormPrice;

	@FindBy(xpath = "//dt[contains(text(),'Base Labor Rate')]/following::dd/input[@id='base_labor_rate']")
	WebElement getBaseLaborRatePrice;

	@FindBy(xpath = "//a[contains(normalize-space(),'Authorization Builder')]")
	WebElement tabAuthorizationBuilder;

	@FindBy(xpath = "//input[@id='authorization_type']")
	WebElement inputAuthoizationName;

	@FindBy(xpath = "//input[@value='Select Some Options']")
	WebElement inputSelectState;

	@FindBy(xpath = "//label[contains(normalize-space(),'Rush Request')]//preceding::span[1]")
	WebElement RushRequestPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Affidavit')]//preceding::span[1]")
	WebElement AffidavitPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Archived Records Search')]//preceding::span[1]")
	WebElement ArchivedRecordsSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Notarize Records')]//preceding::span[1]")
	WebElement NotarizeRecordsSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Record Certification')]//preceding::span[1]")
	WebElement RecordCertificationSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Disability Form')]//preceding::span[1]")
	WebElement DisabilityFormSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Medical Image')]//preceding::span[1]")
	WebElement MedicalImageSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Retrieval Service')]//preceding::span[1]")
	WebElement RetrievalServiceSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Deposition Forms')]//preceding::span[1]")
	WebElement DepositionFormsSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Witness Fee')]//preceding::span[1]")
	WebElement WitnessFeeSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Film Breakdown')]//preceding::span[1]")
	WebElement FilmBreakdownSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'Postage')]//preceding::span[1]")
	WebElement PostageSearchPrice;

	@FindBy(xpath = "//label[contains(normalize-space(),'FMLA Form')]//preceding::span[1]")
	WebElement FMLAFormSearchPrice;

	@FindBy(xpath = "//a[contains(text(),'Retrieval Packet Builder')]")
	WebElement adminServiceTabRetrievalPacketBuilder;

	@FindBy(xpath = "//input[@id='retrieval_document_document']")
	WebElement uplaodDocumentRetievalDocument;

	@FindBy(xpath = "//input[@id='retrieval_document_document_name']")
	WebElement inputDocumentName;
	
	@FindBy(xpath = "//input[@value='Save document']")
	WebElement buttonSaveDocuments;
	
	@FindBy(xpath = "//td[contains(text(),'Testing 1')]/following::div[@class='dropdown pull-right']")
	WebElement buttonThreeDots;
	
	@FindBy(xpath = "//div[@class='dropdown pull-right open']//a[@class='delete_medical_record_form'][contains(normalize-space(),'Delete')]")
	WebElement deleteTheUploadDocument;
	
	@FindBy(xpath = "//td[contains(text(),'Automation Testing 1')]")
	WebElement searchFile;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Fax')]")
	WebElement buttonFaxCustodianAccount;
	
	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;
	
	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;
	
	@FindBy(xpath = "//b[contains(text(),'Custodian Price')]")
	WebElement headingCustodianPrice;
	
	@FindBy(xpath = "//a[contains(text(),'Mobile Services')]")
	WebElement tabMobileService;
	
	@FindBy(xpath = "//h4[normalize-space()='Delivery Services:']")
	WebElement headingForDeliveryService;

	
		public AdminServicePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Services Page from the admin page
	 */
	public void openAdminServicePage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownServicesPage));
		adminDropDownServicesPage.click();
		TestListener.infoMessage("Opening of Admin Service Page");
		wait.until(ExpectedConditions.visibilityOf(servicesTab));
	}

	public String setAndGetPriceForFaxService() {
		String newPrice = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(getFaxPrice));
			String price = getFaxPrice.getAttribute("value");
			System.out.println("Fax Price is :- " + price);
			TestListener.infoMessage("Old Fax Price is "+price);
			getFaxPrice.clear();
			getFaxPrice.sendKeys(TestUtil.getRandomNumericString(2));
			buttonSave.click();
			wait.until(ExpectedConditions.visibilityOf(savedMessage));
			newPrice = getFaxPrice.getAttribute("value");
			System.out.println("New Fax Price is :- " + newPrice);
			TestListener.infoMessage("New Fax Price is "+newPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPrice;
	}

	public void verifyFaxReturnPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(FaxReturnPrice));
		String verifyPrice = FaxReturnPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully "+newPrice);
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessageFail("Price NOT-Matched Successfully "+newPrice);
		}
	}

	public String setAndGetPriceForRushRequestService() {
		wait.until(ExpectedConditions.visibilityOf(getRushRequestPrice));
		String Price = getRushRequestPrice.getAttribute("value");
		System.out.println("Rush Request Price is :- " + Price);
		TestListener.infoMessage("Old Rush Request Price is :- "+Price);
		getRushRequestPrice.clear();
		getRushRequestPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getRushRequestPrice.getAttribute("value");
		System.out.println("New Rush Request Price is :- " + newPrice);
		TestListener.infoMessage("New Rush Request Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyRushRequestPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(RushRequestPrice));
		String verifyPrice = RushRequestPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully "+newPrice);
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessageFail("Price NOT-Matched Successfully "+newPrice);
		}
	}

	public String setAndGetPriceForAffidavitService() {
		wait.until(ExpectedConditions.visibilityOf(getAffidavitPrice));
		String Price = getAffidavitPrice.getAttribute("value");
		System.out.println("Affidavit Price is :- " + Price);
		TestListener.infoMessage("Old Affidavit Price is :- "+Price);
		getAffidavitPrice.clear();
		getAffidavitPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getAffidavitPrice.getAttribute("value");
		System.out.println("New Affidavit Price is :- " + newPrice);
		TestListener.infoMessage("New Affidavit Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyAffidavitPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(AffidavitPrice));
		String verifyPrice = AffidavitPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully "+newPrice);
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessageFail("Price NOT-Matched Successfully "+newPrice);
		}
	}

	public String setAndGetPriceForArchivedRecordsSearchService() {
		wait.until(ExpectedConditions.visibilityOf(getArchivedRecordsSearchPrice));
		String Price = getArchivedRecordsSearchPrice.getAttribute("value");
		System.out.println("Archived Records Search Price is :- " + Price);
		TestListener.infoMessage("Old Archived Records Search Price is :- "+Price);
		getArchivedRecordsSearchPrice.clear();
		getArchivedRecordsSearchPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getArchivedRecordsSearchPrice.getAttribute("value");
		System.out.println("New Archived Records Search Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyArchivedRecordsPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(ArchivedRecordsSearchPrice));
		String verifyPrice = ArchivedRecordsSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");

		}
	}

	public String setAndGetPriceForNotarizeRecordsSearchService() {
		wait.until(ExpectedConditions.visibilityOf(getNotarizeRecordsPrice));
		String Price = getNotarizeRecordsPrice.getAttribute("value");
		System.out.println("Notarize Records Price is :- " + Price);
		TestListener.infoMessage("Notarize Records Price is :- " + Price);
		getNotarizeRecordsPrice.clear();
		getNotarizeRecordsPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getNotarizeRecordsPrice.getAttribute("value");
		System.out.println("New Notarize Records Price is :- " + newPrice);
		TestListener.infoMessage("New Notarize Records Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyNotarizeRecordsPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(NotarizeRecordsSearchPrice));
		String verifyPrice = NotarizeRecordsSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForRecordCertificationSearchService() {
		wait.until(ExpectedConditions.visibilityOf(getRecordCertificationPrice));
		String Price = getRecordCertificationPrice.getAttribute("value");
		System.out.println("Record Certification Price is :- " + Price);
		getRecordCertificationPrice.clear();
		getRecordCertificationPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getRecordCertificationPrice.getAttribute("value");
		System.out.println("New Record Certification Price is :- " + newPrice);
		TestListener.infoMessage("New Record Certification Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyRecordCertificationPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(RecordCertificationSearchPrice));
		String verifyPrice = RecordCertificationSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForDisabilityFormSearchService() {
		wait.until(ExpectedConditions.visibilityOf(getDisabilityFormPrice));
		String Price = getDisabilityFormPrice.getAttribute("value");
		System.out.println("Disability Form Price is :- " + Price);
		getDisabilityFormPrice.clear();
		getDisabilityFormPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getDisabilityFormPrice.getAttribute("value");
		System.out.println("New Disability Form Price is :- " + newPrice);
		TestListener.infoMessage("New Disability Form Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyDisabilityFormPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(DisabilityFormSearchPrice));
		String verifyPrice = DisabilityFormSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForPayByCheckSearchService() {
		wait.until(ExpectedConditions.visibilityOf(getPayByCheckPrice));
		String Price = getPayByCheckPrice.getAttribute("value");
		System.out.println("Pay By Check Price is :- " + Price);
		getPayByCheckPrice.clear();
		getPayByCheckPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getPayByCheckPrice.getAttribute("value");
		System.out.println("New Pay By Check Price is :- " + newPrice);
		TestListener.infoMessage("New Pay By Check Price is :- " + newPrice);
		return newPrice;
	}

	public String setAndGetPriceForMedicalImagesService() {
		wait.until(ExpectedConditions.visibilityOf(getMedicalImagesPrice));
		String Price = getMedicalImagesPrice.getAttribute("value");
		System.out.println("Medical Images Price is :- " + Price);
		getMedicalImagesPrice.clear();
		getMedicalImagesPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getMedicalImagesPrice.getAttribute("value");
		System.out.println("New Medical Images Price is :- " + newPrice);
		TestListener.infoMessage("New Medical Images Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyMedicalImagePrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(MedicalImageSearchPrice));
		String verifyPrice = MedicalImageSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForRetrievalService() {
		wait.until(ExpectedConditions.visibilityOf(getRetrievalServicePrice));
		String Price = getRetrievalServicePrice.getAttribute("value");
		System.out.println("Retrieval Service Price is :- " + Price);
		getRetrievalServicePrice.clear();
		getRetrievalServicePrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getRetrievalServicePrice.getAttribute("value");
		System.out.println("New Retrieval Service Price is :- " + newPrice);
		TestListener.infoMessage("New Retrieval Service Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyRetrievalServicePrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(RetrievalServiceSearchPrice));
		String verifyPrice = RetrievalServiceSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForDepositionFormsService() {
		wait.until(ExpectedConditions.visibilityOf(getDepositionFormsPrice));
		String Price = getDepositionFormsPrice.getAttribute("value");
		System.out.println("Deposition Forms Service Price is :- " + Price);
		getDepositionFormsPrice.clear();
		getDepositionFormsPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getDepositionFormsPrice.getAttribute("value");
		System.out.println("New Deposition Forms Service Price is :- " + newPrice);
		TestListener.infoMessage("New Deposition Forms Service Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyDepositionFormsPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(DepositionFormsSearchPrice));
		String verifyPrice = DepositionFormsSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForWitnessFeeService() {
		wait.until(ExpectedConditions.visibilityOf(getWitnessFeePrice));
		String Price = getWitnessFeePrice.getAttribute("value");
		System.out.println("Witness Fee Service Price is :- " + Price);
		getWitnessFeePrice.clear();
		getWitnessFeePrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getWitnessFeePrice.getAttribute("value");
		System.out.println("New Witness Fee Service Price is :- " + newPrice);
		TestListener.infoMessage("New Witness Fee Service Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyWitnessFeePrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(WitnessFeeSearchPrice));
		String verifyPrice = WitnessFeeSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForFilmBreakdownService() {
		wait.until(ExpectedConditions.visibilityOf(getFilmBreakdownPrice));
		String Price = getFilmBreakdownPrice.getAttribute("value");
		System.out.println("Film Breakdown Service Price is :- " + Price);
		TestListener.infoMessage("Film Breakdown Service Price is :- " + Price);
		getFilmBreakdownPrice.clear();
		getFilmBreakdownPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getFilmBreakdownPrice.getAttribute("value");
		System.out.println("New Film Breakdown Service Price is :- " + newPrice);
		TestListener.infoMessage("New Film Breakdown Service Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyFilmBreakdownPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(FilmBreakdownSearchPrice));
		String verifyPrice = FilmBreakdownSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForStorageFeePatientsService() {
		wait.until(ExpectedConditions.visibilityOf(getStorageFeePatientsPrice));
		String Price = getStorageFeePatientsPrice.getAttribute("value");
		System.out.println("Storage Fee-Patients Service Price is :- " + Price);
		TestListener.infoMessage("Storage Fee-Patients Service Price is :- " + Price);
		getStorageFeePatientsPrice.clear();
		getStorageFeePatientsPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getStorageFeePatientsPrice.getAttribute("value");
		System.out.println("New Storage Fee-Patients Service Price is :- " + newPrice);
		TestListener.infoMessage("New Storage Fee-Patients Service Price is :- " + newPrice);
		return newPrice;
	}

	public String setAndGetPriceForPostageService() {
		wait.until(ExpectedConditions.visibilityOf(getPostagePrice));
		String Price = getPostagePrice.getAttribute("value");
		System.out.println("Postage Service Price is :- " + Price);
		TestListener.infoMessage("Postage Service Price is :- " + Price);
		getPostagePrice.clear();
		getPostagePrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getPostagePrice.getAttribute("value");
		System.out.println("New Postage Service Price is :- " + newPrice);
		TestListener.infoMessage("New Postage Service Price is :- " + newPrice);
		return newPrice;
	}

	public void verifyPostagePrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(PostageSearchPrice));
		String verifyPrice = PostageSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForFMLAFormService() {
		wait.until(ExpectedConditions.visibilityOf(getFMLAFormPrice));
		String Price = getFMLAFormPrice.getAttribute("value");
		System.out.println("FMLA Form Service Price is :- " + Price);
		TestListener.infoMessage("FMLA Form Service Price is :- " + Price);
		getFMLAFormPrice.clear();
		getFMLAFormPrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getFMLAFormPrice.getAttribute("value");
		System.out.println("New FMLA Form Service Price is :- " + newPrice);
		TestListener.infoMessage("New FMLA Form Service Price is :- " + newPrice);

		return newPrice;
	}

	public void verifyFMLAFormPrice(String newPrice) {
		wait.until(ExpectedConditions.visibilityOf(FMLAFormSearchPrice));
		String verifyPrice = FMLAFormSearchPrice.getText();
		if (verifyPrice.contains(newPrice)) {
			Assert.assertTrue(true, "Price Matched");
			System.out.println("Price Matched Successfully");
			TestListener.infoMessage("Price Matched Successfully");
		} else {
			Assert.assertFalse(false, "Price NOT-Matched");
			System.out.println("Price NOT-Matched Successfully");
			TestListener.infoMessage("Price NOT-Matched Successfully");
		}
	}

	public String setAndGetPriceForBaseLaborRateService() {
		wait.until(ExpectedConditions.visibilityOf(getBaseLaborRatePrice));
		String Price = getBaseLaborRatePrice.getAttribute("value");
		System.out.println("Base Labor Rate Service Price is :- " + Price);
		TestListener.infoMessage("Base Labor Rate Service Price is :- " + Price);

		getBaseLaborRatePrice.clear();
		getBaseLaborRatePrice.sendKeys(TestUtil.getRandomNumericString(2));
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String newPrice = getBaseLaborRatePrice.getAttribute("value");
		System.out.println("New Base Labor Rate Service Price is :- " + newPrice);
		TestListener.infoMessage("New Base Labor Rate Service Price is :- " + newPrice);

		return newPrice;
	}

	public void openAdminAuthorizationBuilderTab() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownServicesPage));
		adminDropDownServicesPage.click();
		TestListener.infoMessage("Open admin Service Page");
		wait.until(ExpectedConditions.visibilityOf(servicesTab));
		tabAuthorizationBuilder.click();
		TestListener.infoMessage("Open Authorization Builder Tab");
	}

	public String addNewAuthorizationBuilder(String StateName) {
		wait.until(ExpectedConditions.elementToBeClickable(inputAuthoizationName));
		String tempNo = TestUtil.getRandomNumericString(3);
		inputAuthoizationName.sendKeys("AutomationAuthorization" + tempNo);
		TestListener.infoMessage("Add new Authorization Builder ");
		inputSelectState.click();
		inputSelectState.sendKeys(StateName);
		inputSelectState.sendKeys(Keys.ENTER);
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String authorizationName = "AutomationAuthorization" + tempNo;
		TestListener.infoMessage("Add new Authorization Builder Name is "+authorizationName);
		return authorizationName;
	}

	public void openTabRetrievalPacketBuilder() {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(adminServiceTabRetrievalPacketBuilder));
			adminServiceTabRetrievalPacketBuilder.click();
			//wait.until(ExpectedConditions.elementToBeClickable(uplaodDocumentRetievalDocument));
			if (TestUtil.isElementDisplayed(searchFile)) {
				deleteDocument();
			}
			
			//js.executeScript("arguments[0].click();", uplaodDocumentRetievalDocument);
			 Actions builder = new Actions(driver);
		        builder.moveToElement(uplaodDocumentRetievalDocument).click(uplaodDocumentRetievalDocument);
		        builder.perform();
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
			inputDocumentName.sendKeys("Automation Testing 1");
			buttonSaveDocuments.click();
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.visibilityOf(savedMessage));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDocument() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonThreeDots));
		buttonThreeDots.click();
		wait.until(ExpectedConditions.visibilityOf(deleteTheUploadDocument));
		deleteTheUploadDocument.click();
		TestUtil.hardWait(2);
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
	}
	
	public void verifyRetrievalPacketBuilder() {
		wait.until(ExpectedConditions.visibilityOf(buttonFaxCustodianAccount));
		buttonFaxCustodianAccount.click();
		int noOFdocs=driver.findElements(By.xpath("//div[@id='retrieval-fax-detailes-modal']//p")).size();
		for (int i = 1; i <= noOFdocs; i++) {
			String actualText=driver.findElement(By.xpath("//div[@id='retrieval-fax-detailes-modal']//p["+i+"]")).getText();
			if (actualText.contains("Automation Testing 1")) {
				System.out.println("Retrieval Packet Builder Working as Expected");
				TestListener.infoMessage("Retrieval Packet Builder Working as Expected");
			} else {
				System.out.println("Retrieval Packet Builder NOT-Working as Expected");
				TestListener.infoMessage("Retrieval Packet Builder NOT-Working as Expected");
			}
			
		}
	}
	
	public void processingRequest() {
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
	}
	
	public List<String> getServiceNameList() {
		List<String> listServiceName=new ArrayList<String>();
		int sizeofAdminServiceTab=driver.findElements(By.xpath("//form[@action='/company/service_prices/edit_services']/dl/dt")).size();
			for (int i = 1; i <=sizeofAdminServiceTab; i++) {
				String serviceName=driver.findElement(By.xpath("//form[@action='/company/service_prices/edit_services']/dl["+i+"]/dt")).getText();
				listServiceName.add(serviceName);
			}
			System.out.println("List of Service is :- "+listServiceName);
			return listServiceName;
	}
	
	public List<String> getServiceListTabMobileService() {
		wait.until(ExpectedConditions.elementToBeClickable(tabMobileService));
		tabMobileService.click();
		List<String> listServiceName=new ArrayList<String>();
		int sizeofAdminServiceTab=driver.findElements(By.xpath("//form[@action='/company/service_prices/edit_mobile_services']/dl/dt")).size();
			for (int i = 1; i <=sizeofAdminServiceTab; i++) {
				String serviceName=driver.findElement(By.xpath("//form[@action='/company/service_prices/edit_mobile_services']/dl["+i+"]/dt")).getText();
				listServiceName.add(serviceName);
			}
			System.out.println("List of Service is From Mobile Service Tab:- "+listServiceName);
			return listServiceName;
	}
	
	public List<String> getServiceListFromRequest() {
		wait.until(ExpectedConditions.visibilityOf(headingForDeliveryService));
		List<String> listServiceName=new ArrayList<String>();
		int sizeofDeliveryServices=driver.findElements(By.xpath("//ul[@class='services-list delivery']/li/label")).size();
		for (int i = 1; i <=sizeofDeliveryServices; i++) {
			if (i==3) {
				i=4;
				String serviceName=driver.findElement(By.xpath("//ul[@class='services-list delivery']/li["+i+"]/label")).getText();
				listServiceName.add(serviceName);
			} else {
				String serviceName=driver.findElement(By.xpath("//ul[@class='services-list delivery']/li["+i+"]/label")).getText();
				listServiceName.add(serviceName);
			}
		}
		System.out.println("List of Delivery Service is:->>>> "+listServiceName);
		int sizeofAdditionalServices=driver.findElements(By.xpath("//ul[@class='services-list ']/li/label")).size();
		for (int i = 1; i <=sizeofAdditionalServices; i++) {
			String serviceName=driver.findElement(By.xpath("//ul[@class='services-list ']/li["+i+"]/label")).getText();
			listServiceName.add(serviceName);
			if (i==sizeofAdditionalServices-2) {
				break;
			}
		}
		System.out.println("List of Additional Service is:->>>> "+listServiceName);
		int sizeofPaymentMethod=driver.findElements(By.xpath("//div[@class='payment-method']/ul[@class='services-list ']/li/label")).size();
		for (int i = 1; i <=sizeofPaymentMethod; i++) {
			String serviceName=driver.findElement(By.xpath("//div[@class='payment-method']/ul[@class='services-list ']/li["+i+"]/label	")).getText();
			listServiceName.add(serviceName);
		}
		System.out.println("List of Service is From Request Creation:- "+listServiceName);
		return listServiceName;
	}
	
}
