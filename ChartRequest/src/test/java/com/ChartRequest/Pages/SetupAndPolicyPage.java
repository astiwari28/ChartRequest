package com.ChartRequest.Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;

public class SetupAndPolicyPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	HashMap<String, String> newValues = new HashMap<String, String>();
	String expectedPriceInstantDownload, expectedPriceFaxReturn, expectedPriceAffidavit;
	CreateRequest createRequest=new CreateRequest();

	public SetupAndPolicyPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='service_price_ids_10']")
	WebElement inputPriceInstantDownload;

	@FindBy(xpath = "//input[@id='service_price_ids_2']")
	WebElement inputPriceFaxReturn;

	@FindBy(xpath = "//input[@id='service_price_ids_4']")
	WebElement inputPriceAffidavit;

	@FindBy(xpath = "//a[contains(text(),'Edit Services and Policy')]")
	WebElement buttonEditServiceAndPolicy;

	@FindBy(xpath = "//td[@align='right']//input[@value='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//ul[contains(@class,'services-list delivery')]//li[1]/span")
	WebElement instantDownloadUpdatedPrice;

	@FindBy(xpath = "//ul[contains(@class,'services-list delivery')]//li[2]/span")
	WebElement FaxUpdatedPrice;

	public void openEditServiceAndPolicyPage() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditServiceAndPolicy));
		buttonEditServiceAndPolicy.click();
		TestListener.infoMessage("Open Edit Service And Policy Page");
	}

	public HashMap<String, String> changePrice(String PriceInstantDownload, String PriceFaxReturn, String PriceAffidavit) {
		wait.until(ExpectedConditions.elementToBeClickable(inputPriceInstantDownload));
		inputPriceInstantDownload.clear();
		inputPriceInstantDownload.sendKeys(PriceInstantDownload);
		inputPriceFaxReturn.clear();
		inputPriceFaxReturn.sendKeys(PriceFaxReturn);
		inputPriceAffidavit.clear();
		inputPriceAffidavit.sendKeys(PriceAffidavit);
		saveButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditServiceAndPolicy));
		buttonEditServiceAndPolicy.click();
		expectedPriceInstantDownload = inputPriceInstantDownload.getAttribute("value");
		newValues.put("PriceInstantDownload", expectedPriceInstantDownload);
		expectedPriceFaxReturn = inputPriceFaxReturn.getAttribute("value");
		newValues.put("PriceFaxReturn", expectedPriceFaxReturn);
		expectedPriceAffidavit = inputPriceAffidavit.getAttribute("value");
		newValues.put("PriceAffidavit", expectedPriceAffidavit);
		System.out.println("Value of HashMap is:- " + newValues);
		TestListener.infoMessage("Price of Chnage is "+newValues);
		return newValues;
	}

	public void getPriceInstantDownload() {
		wait.until(ExpectedConditions.elementToBeClickable(instantDownloadUpdatedPrice));
		String valueInstantDownload = instantDownloadUpdatedPrice.getText();
		String valueFax = FaxUpdatedPrice.getText();
		
		for (Map.Entry<String, String> entry : newValues.entrySet()) {
			if (entry.getKey().contains("InstantDownload")) {
				String actualValue=entry.getValue().replaceAll("$", "");
				System.out.println("Value of Actual= "+actualValue+" expected Value= "+expectedPriceInstantDownload);
				TestListener.infoMessage("Actual Value "+actualValue+" Expected Value "+expectedPriceInstantDownload);
				Assert.assertEquals(actualValue, expectedPriceInstantDownload,"Value of Instant Downlaod Matched");
			} else if (entry.getKey().contains("FaxReturn")) {
				String actualValue=entry.getValue().replaceAll("$", "");
				System.out.println("Value of Actual= "+actualValue+" expected Value= "+expectedPriceFaxReturn);
				TestListener.infoMessage("Actual Value "+actualValue+" Expected Value "+expectedPriceFaxReturn);
				Assert.assertEquals(actualValue, expectedPriceFaxReturn,"Value of Fax Return Matched");
			} else if(entry.getKey().contains("Affidavit")){
				String actualValue=entry.getValue().replaceAll("$", "");
				System.out.println("Value of Actual= "+actualValue+" expected Value= "+expectedPriceAffidavit);
				TestListener.infoMessage("Actual Value "+actualValue+" Expected Value "+expectedPriceAffidavit);
				Assert.assertEquals(actualValue, expectedPriceAffidavit,"Value of Affidavit Matched");
			}
		}
		createRequest.abandonRequest();
	}
	
}
