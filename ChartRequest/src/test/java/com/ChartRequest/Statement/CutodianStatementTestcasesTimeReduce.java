package com.ChartRequest.Statement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CutodianStatementTestcasesTimeReduce {
	
	
	List<String> cNames1 = Arrays.asList("162","681","890","1546","1583");
	List<String> cNames2 = Arrays.asList("1595","1685","1701","1857","1858");
	
	public void openBrowser(String URL, String username, String password) {}
	
	@Test
	public void testCase1() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		CustodianStatement_Old custodianStatement = new CustodianStatement_Old();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(GlobalVariables.URL);
		
		String currentURL=driver.getCurrentUrl();
		if (currentURL.contains("staging")) {
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.xpath("//a[text()='Proceed to staging.chartrequest.com (unsafe)']")).click();
		}
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Login')]"))));
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Login')]")).click();
		 driver.findElement(By.xpath("//input[@id='login']")).sendKeys(GlobalVariables.custodianEmailStaging);
		 driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(GlobalVariables.password);
	     driver.findElement(By.xpath("//button[@class='btn-login btn']")).click();
	
		System.out.println("Test case 1");
		//List<String> cNames = custodianStatement.listofName();
		System.out.println("List is " + cNames1);
		for (String custodianID : cNames1) {
			TestUtil.openNewTabWithURL("https://staging.chartrequest.com/company/custodians/" + custodianID);
			TestUtil.hardWait(3);
			custodianStatement.searchCustodianByURL(custodianID);
			TestUtil.closeCurrentTab();
			System.out.println("*****Closed the Tab*****");

		}
	
	}
}
