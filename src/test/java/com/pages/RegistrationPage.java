package com.pages;



import java.util.List;
import java.util.Map;
import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;


import com.abstractPages.AbstractMain;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractMain {
    public static By LoginPageCreateAccountButton = By.cssSelector(".downloadsblock-link:nth-child(4) .btn-anim2");
    public static By RegistrationPage = By.cssSelector("#Main");
    public static By AddressDetailsLink = By.cssSelector(".step-wrapper:nth-child(2) .step-wrapper-cta-title");
    public static By TitleDropDown = By.cssSelector(".selectBox.form-control.selectBox-dropdown");
    public static By FirstName = By.cssSelector("#FirstName");
    public static By LastName = By.cssSelector("#LastName");
    public static By TelephoneNumber = By.cssSelector("#TelephoneNumber");
    public static By PostCode = By.cssSelector("#PostCode");
    public static By Address1 = By.cssSelector("#Address1");
    public static By Address2 = By.cssSelector("#Address2");
    public static By Town = By.cssSelector("#Town");
    public static By AccountDetailLink = By.cssSelector(".row:nth-child(7) .button");
    public static By CountryDrpDown = By.cssSelector(".selectBox.form-control.ctaddress-country.selectBox-dropdown");
    public static By eMail = By.cssSelector("#Email");
    public static By ConfirmEmail = By.cssSelector("#ConfirmEmail");
    public static By Password = By.cssSelector("#Password");
    public static By ConfirmPassword = By.cssSelector("#ConfirmPassword");
    public static By Terms = By.cssSelector("#GDPR");
    public static By Conditions = By.cssSelector("#TsAndCs");
    public static By CreateAccountButton = By.cssSelector(".btn_white_to_red > .btn-anim2");


    public void goToRegistrationPage(String createAnAccount) throws InterruptedException {
        WebElement element = driver.findElement(LoginPageCreateAccountButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
//       action.clickElement(LoginPageCreateAccountButton);

    }

    public void verifyRegistrationPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/registration")); // check URL contains /registration
        Assert.assertTrue(driver.getTitle().contains("Registration - Pony Club"));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Registration"));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Personal Details"));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Address Details"));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Account Details"));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Terms & Conditions"));
        Assert.assertTrue(action.isElementPresent(CreateAccountButton));
    }

    public void enterPersonalDetails(DataTable personalDetails) throws InterruptedException {
        List<Map<String, String>> list = personalDetails.asMaps(String.class, String.class);
        driver.findElement(TitleDropDown).sendKeys(list.get(0).get("Title"));
        action.sendElement(FirstName, list.get(0).get("FirstName"));
        action.sendElement(LastName, list.get(0).get("LastName"));
        action.sendElement(TelephoneNumber, list.get(0).get("TelephoneNumber"));

    }

    public void enterAddressDetails(DataTable address) throws InterruptedException {

        action.clickElement(AddressDetailsLink);
        Thread.sleep(2000);
        List<Map<String, String>> list = address.asMaps(String.class, String.class);
        action.sendElement(PostCode, list.get(0).get("PostCode"));
//        action.sendElement(PostCode,"B1 1JY");
        Thread.sleep(5000);
        action.clickElement(By.cssSelector(".pcaautocomplete:nth-child(7) .pcadescription"));
        Thread.sleep(5000);
        action.clickElement(By.cssSelector(".pcalastitem:nth-child(4)"));
//        action.clickElement(By.cssSelector("body > div.pca > div:nth-child(7) > div.pca.pcalist > div.pcaitem.pcaselected"));
        Thread.sleep(2000);
        if (driver.getPageSource().contains("Sorry, we could not retrieve this address")) {

            action.sendElement(PostCode, list.get(0).get("PostCode"));
            action.sendElement(Address1, list.get(0).get("Address 1"));
            action.sendElement(Address2, list.get(0).get("Address 2"));
            action.sendElement(Town, list.get(0).get("Town"));
            driver.findElement(CountryDrpDown).sendKeys(list.get(0).get("Country"));
            Thread.sleep(2000);
            action.clickElement(By.cssSelector("a[rel='42579c4a-ebd4-e711-a94b-00224801b4c8']"));
            Thread.sleep(5000);

        }


    }

    public void enterAccountDetails(DataTable account) throws InterruptedException {
        action.clickElement(By.cssSelector(".step-wrapper:nth-child(3) .step-wrapper-cta-title"));
        Random rn = new Random();
        int rNumber = rn.nextInt(10000 - 10 + 1) + 1;
        String rNum = String.valueOf(rNumber);
        Thread.sleep(5000);
        List<Map<String, String>> list = account.asMaps(String.class, String.class);
        action.sendElement(eMail, rNum+list.get(0).get("eMail"));
        action.sendElement(ConfirmEmail, rNum+list.get(0).get("ConfirmEmail"));
        action.sendElement(Password, list.get(0).get("Password"));
        action.sendElement(ConfirmPassword, list.get(0).get("ConfirmPassword"));
        Thread.sleep(5000);


    }
    public void acceptTermsAndConditions() throws InterruptedException {
        action.clickElement(By.cssSelector(".step-wrapper:nth-child(4) .step-wrapper-cta-title"));
        Thread.sleep(5000);
        action.clickElement(Terms);
        action.clickElement(Conditions);
        Thread.sleep(5000);

    }

    public void submitRegistration(String createAccount) throws InterruptedException {
        action.clickElement(CreateAccountButton);

    }
    public void verifyRegistrationConfirmation(String thankYou) throws InterruptedException {
        utils.waitForSeconds();
//        if(action.getElementText(RegistrationPage).contains("field is required")){
//            System.out.println(action.getElementText(RegistrationPage));
//        }
        Assert.assertTrue(action.getElementText(RegistrationPage).contains(thankYou));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("An email has been sent to you to enable you to activate your account. Please click the link in the email to go to the Login Page"));
    }

    public void checkRedirectionToLoginPage() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL+"/login"));
    }

}
