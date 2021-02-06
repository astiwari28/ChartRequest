package com.ChartRequest.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;

public class LoginPage extends BrowserConfiguration {

	WebDriverWait wait=new WebDriverWait(driver, 30);
	
    ReadOTPFromEmailGmail readOtpFromEmailGmail = new ReadOTPFromEmailGmail();
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Login')]")
    WebElement logInButton;
    @FindBy(xpath = "//input[@id='login']")
    WebElement uiemailid;
    @FindBy(xpath = "//input[@id='user_password']")
    WebElement uipassword;
    @FindBy(xpath = "//button[@class='btn-login btn']")
    WebElement loginButton;
    @FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
    WebElement userProfile;
    @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
    WebElement signOutButon;
    @FindBy(xpath = "//div[@id='alert']")
    WebElement alertMessage;
    @FindBy(xpath = "//a[@class='login-provider']")
    WebElement loginSignupGoogle;
    @FindBy(xpath = "//a[contains(text(),'Sign up now for free')]")
    WebElement SignUponLogin;
    @FindBy(xpath = "//u[contains(text(),'Sign up as a Patient')]")
    WebElement SignupasaPatient;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement HomeOnLogin;
    @FindBy(xpath = "//a[contains(text(),'+1 (888) 895-8366')]")
    WebElement homePageVerifer;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement aboutOnLogin;
    @FindBy(xpath = "//h3[contains(text(),'Our Mission: Transforming Health Information Excha')]")
    WebElement aboutPageVerifer;
    @FindBy(xpath = "//a[contains(text(),'Benefits')]")
    WebElement benefitsonLogin;
    @FindBy(xpath = "//span[contains(text(),'Efficiency')]")
    WebElement benefitsPageVerifier;
    @FindBy(xpath = "//a[contains(text(),'Request a Demo')]")
    WebElement requestADemoonLogin;
    @FindBy(xpath = "//h2[contains(text(),'See Our Health Information Exchange Software in Ac')]")
    WebElement requestADemoVerifier;
    @FindBy(xpath = "//a[contains(text(),'FAQ')]")
    WebElement FAQonLogin;
    @FindBy(xpath = "//h3[contains(text(),'FAQs')]")
    WebElement FAQVerifier;
    @FindBy(xpath = "//a[contains(text(),'Get help accessing your account')]")
    WebElement getHelpLogin;
    @FindBy(xpath = "//h3[contains(text(),'Get the Specific Support You Need')]")
    WebElement contactPageVerifier;
    @FindBy(linkText = "Forgot Password?")
    WebElement forgetPasswordLink;
    @FindBy(xpath = "//input[@id='reset-pwd-email']")
    WebElement forgetPasswordInput;
    @FindBy(xpath = "//button[@id='login-block-reset-password']")
    WebElement forgotMyPasswordButton;
    @FindBy(xpath = "//h4[contains(text(),'Reset Password Sent!')]")
    WebElement statusOfForgetPassword;
    @FindBy(xpath = "//div[@id='reset-password-sent']//button[@class='btn btn-default'][contains(text(),'Close')]")
    WebElement closeButtonForgotPassword;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    WebElement alertOfForgetPassword;
    @FindBy(xpath = "//input[@id='remember_me']")
    WebElement rememberMeCheckboxElement;
    @FindBy(xpath = "//a[contains(text(),'Request Status')]")
    WebElement requestStatusLink;
    @FindBy(xpath = "//input[@id='request_id']")
    WebElement inputRequestNo;
    @FindBy(xpath = "//button[@id='recaptcha_btn']")
    WebElement checkStatusButton;
    @FindBy(xpath = "//div[@class='text-error']")
    WebElement errorMessageRequestStatus;
    @FindBy(xpath = "//a[contains(text(),'Login with SSO')]")
    WebElement loginSSO;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputSSOEmailId;
    @FindBy(xpath = "//input[@name='commit']")
    WebElement buttonLogin;
    @FindBy(xpath = "//span[@class='smlText']")
    WebElement loginWithSAMLButton;
    @FindBy(xpath = "//span[contains(text(),'Log in with FullCycle SSO')]")
    WebElement loginWIthSSO;
    @FindBy(xpath = "//input[@id='username']")
    WebElement inputLoginWithSSOEmailId;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputLoginWithSSOPassword;
    @FindBy(xpath = "//input[@id='kc-login']")
    WebElement buttonLoginWithSSOLogin;
    
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputloginEmailIdStripe;
    
    @FindBy(xpath = "//input[@id='old-password']")
    WebElement inputloginPasswordStripe;
    
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement buttonContuine;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login to application
     * @param userName
     * @param password
     * */
    
    public CreateRequest login(String username, String password) {
    	try {
            logInButton.click();
            uiemailid.sendKeys(username);
            uipassword.sendKeys(password);
            loginButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new CreateRequest();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login to application but its doesn't return anything
     * @param userName
     * @param password
     * */   
    public void loginWithOutReturn(String username, String password) {
        logInButton.click();
        uiemailid.sendKeys(username);
        uipassword.sendKeys(password);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String message = alertMessage.getText();
        System.out.println("Message is :: " + message);
    }

    /**
     * @author ashutosh.tiwari
     * @Description Get the title of the page
     * */
    public String verifyTitle() {
        return driver.getTitle();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Logout from the application
     * */
    public void logout() {
        userProfile.click();
        signOutButon.click();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on the login Button when the application open
     * */
    public void loginButton() {
        logInButton.click();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login to application without user name and without password
     * @param blank userName
     * @param blank password
     * */ 
    public void loginWithoutUserNameandPassword(String username, String password) {
        logInButton.click();
        if (username.isEmpty() && password.isEmpty()) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginButton.click();
            TestUtil.hardWait(5);
            String alertValue = uiemailid.getAttribute("validationMessage");
            System.out.println("message is " + alertValue);
            Assert.assertEquals(alertValue, "Please fill out this field.");
        } else if (username.isEmpty()) {
            uipassword.sendKeys(password);
            loginButton.click();
            TestUtil.hardWait(10);
            String alertValue = alertMessage.getText();
            Assert.assertTrue(alertValue.contains("Login Failed"));
        } else if (password.isEmpty()) {
            uiemailid.sendKeys(username);
            loginButton.click();
            TestUtil.hardWait(5);
            String alertValue = alertMessage.getText();
            Assert.assertTrue(alertValue.contains("Login Failed"));
        }
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login to application using email credinatals
     * @param blank userName
     * @param blank password
     * */ 
    public void loginWithGoogle() {
        loginSignupGoogle.click();
        readOtpFromEmailGmail.readEmailForOTP("chartrequest.staging@gmail.com", "FullCycle@2020");
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Signup Page present on the Login Page and also validating the page
     * */ 
    public void signUpOnLogin() {
        SignUponLogin.click();
        TestUtil.swtichToTab(1);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//u[contains(text(),'Sign up as a Patient')]")));
        String actualText = SignupasaPatient.getText();
        Assert.assertEquals(actualText, "Sign up as a Patient");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Home Page Link present on the Login Page and also validating the page
     * */ 
    public void homeOnLogin() {
        HomeOnLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'+1 (888) 895-8366')]")));
        String actualText = homePageVerifer.getText();
        Assert.assertEquals(actualText, "+1 (888) 895-8366");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on About Us Link present on the Login Page and also validating the page
     * */ 
    public void aboutOnLogin() {
        aboutOnLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Our Mission: Transforming Health Information Excha')]")));
        String actualText = aboutPageVerifer.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "Our Mission: Transforming Health Information Exchange with Technology");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Benefit Link present on the Login Page and also validating the page
     * */ 
    public void benefitOnLogin() {
        benefitsonLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Efficiency')]")));
        String actualText = benefitsPageVerifier.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "Efficiency");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Request A Demo Link present on the Login Page and also validating the page
     * */ 
    public void requestADemoOnLogin() {
        requestADemoonLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'See Our Health Information Exchange Software in Ac')]")));
        String actualText = requestADemoVerifier.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "See Our Health Information Exchange Software in Action");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on FAQ Link present on the Login Page and also validating the page
     * */ 
    public void FQAOnLogin() {
        FAQonLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'FAQs')]")));
        String actualText = FAQVerifier.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "FAQs");
        driver.navigate().back();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Get Help Accessing Your Account Link present on the Login Page and also validating the page
     * */ 
    public void GetHelpAccessingYourAccount() {
        logInButton.click();
        getHelpLogin.click();
        TestUtil.swtichTab(1);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Get the Specific Support You Need')]")));
        String actualText = contactPageVerifier.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "Get the Specific Support You Need");
        driver.close();
        TestUtil.swtichTab(0);
    }
    
    /**
     * @author ashutosh.tiwari
     * @Description Click on Forgot Password Link present on the Login Page and also validating the page
     * @param Email Id for Resetting the password
     * */
    public void ForgotPassword(String emailIdForPasswordReset) {
        logInButton.click();
        forgetPasswordLink.click();
        forgetPasswordInput.sendKeys(emailIdForPasswordReset);
        forgotMyPasswordButton.click();
        TestUtil.hardWait(10);
        String actualText = statusOfForgetPassword.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "Reset Password Sent!");
        //      closeButtonForgotPassword.click();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Forgot Password Link present on the Login Page and also validating the page
     * @param Email Id for Resetting the password with wrong email Id
     * */
    public void ForgotPasswordWrongEmail(String emailIdForPasswordReset) {
        logInButton.click();
        forgetPasswordLink.click();
        forgetPasswordInput.sendKeys(emailIdForPasswordReset);
        forgotMyPasswordButton.click();
        String actualText = alertOfForgetPassword.getText();
        System.out.println("Value of actual Text :: " + actualText);
        TestUtil.hardWait(10);
        System.out.println("Value formated ::->" + "User not found for email " + emailIdForPasswordReset);
        Assert.assertEquals(actualText, "You have been previously invited to ChartRequest. The invitation has been re-sent to your email. Please check your inbox.");
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login to application and click on the Remember Me Button
     * @param userName
     * @param password
     * */  
    public void loginRememberMe(String username, String password) {
        logInButton.click();
        uiemailid.sendKeys(username);
        uipassword.sendKeys(password);
        rememberMeCheckboxElement.click();
        logInButton.click();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Request Status Present on the Login Page
     * @param Request Number
     * */  
    public void requestStatus(String RequestNo) {
        requestStatusLink.click();
        inputRequestNo.sendKeys(RequestNo);
        checkStatusButton.click();
    }

    /**
     * @author ashutosh.tiwari
     * @Description Click on Request Status Present on the Login Page with error Message
     * @param Request Number
     * */  
    public void requestStatusWithErrorMessage(String RequestNo) {
        requestStatusLink.click();
        inputRequestNo.sendKeys(RequestNo);
        checkStatusButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='text-error']")));
        String actualText = errorMessageRequestStatus.getText();
        System.out.println("Value of actual Text :: " + actualText);
        Assert.assertEquals(actualText, "Please check your Request ID # or Log in to start a Request.");
    }

    /**
     * @author ashutosh.tiwari
     * @Description Login With SSO Email Id
     * @param SSO Email Id
     * @param Full-Cycle EMail Id
     * @param Full-Cycle Password Id
     * */
    public void loginUsingSSO(String ssoEmailId, String fullCycleEMailId, String fullCyclePasswordId) {
        loginSSO.click();
        inputSSOEmailId.sendKeys(ssoEmailId);
        buttonLogin.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginWithSAMLButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginWIthSSO.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        inputLoginWithSSOEmailId.sendKeys(fullCycleEMailId);
        inputLoginWithSSOPassword.sendKeys(fullCyclePasswordId);
        buttonLoginWithSSOLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Your Requests')]"))));
    }
    
    public void loginStripe(String stripeUserName, String stripePassword) {
    	wait.until(ExpectedConditions.elementToBeClickable(inputloginEmailIdStripe));
    	TestUtil.hardWait(5);
    	inputloginEmailIdStripe.sendKeys(stripeUserName);
    	inputloginPasswordStripe.sendKeys(stripePassword);
    	buttonContuine.click();
    }
}
