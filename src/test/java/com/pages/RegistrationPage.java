package com.pages;



import java.util.List;
import java.util.Map;
import java.util.Random;



import com.abstractPages.AbstractMain;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;


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


    public void goToRegistrationPage(String createAnAccount) {
        WebElement element = driver.findElement(LoginPageCreateAccountButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
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
        utils.waitForSeconds();
        List<Map<String, String>> list = address.asMaps(String.class, String.class);
        action.sendElement(PostCode, list.get(0).get("PostCode"));
        utils.waitForSeconds();
        Thread.sleep(4000);
        utils.webDriverWaitForVisibilityOfElement(By.cssSelector(".pcaautocomplete:nth-child(7) .pcadescription"));
        action.clickElement(By.cssSelector(".pcaautocomplete:nth-child(7) .pcadescription"));
        utils.waitForSeconds();

//        List <WebElement> listings = driver.findElements(By.cssSelector("div.pcaitem"));
//        Random r = new Random();
//        int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
//        listings.get(randomValue).click();

        action.clickElement(By.cssSelector(".pcalastitem:nth-child(4)"));
//        action.clickElement(By.cssSelector("body > div.pca > div:nth-child(7) > div.pca.pcalist > div.pcaitem.pcaselected"));
        utils.waitForSeconds();
        if (driver.getPageSource().contains("Sorry, we could not retrieve this address")) {

            action.sendElement(PostCode, list.get(0).get("PostCode"));
            action.sendElement(Address1, list.get(0).get("Address 1"));
            action.sendElement(Address2, list.get(0).get("Address 2"));
            action.sendElement(Town, list.get(0).get("Town"));
            driver.findElement(CountryDrpDown).sendKeys(list.get(0).get("Country"));
            utils.waitForSeconds();
            action.clickElement(By.cssSelector("a[rel='42579c4a-ebd4-e711-a94b-00224801b4c8']"));
            utils.waitForSeconds();

        }


    }

    public void enterAccountDetails(DataTable account) {
        action.clickElement(By.cssSelector(".step-wrapper:nth-child(3) .step-wrapper-cta-title"));
        Random rn = new Random();
        int rNumber = rn.nextInt(100000 - 10 + 1) + 1;
        String rNum = String.valueOf(rNumber);
        utils.waitForSeconds();
        List<Map<String, String>> list = account.asMaps(String.class, String.class);
        action.sendElement(eMail, rNum + list.get(0).get("eMail"));
        globalHooks.scenario.write("random email address used '" + rNum + list.get(0).get("eMail") + "'");
//        globalHooks.scenario.write(globalHooks.scenario.getStatus());
        action.sendElement(ConfirmEmail, rNum + list.get(0).get("ConfirmEmail"));
        action.sendElement(Password, list.get(0).get("Password"));
        action.sendElement(ConfirmPassword, list.get(0).get("ConfirmPassword"));
        utils.waitForSeconds();

    }
    public void acceptTermsAndConditions() throws InterruptedException {
        action.clickElement(By.cssSelector(".step-wrapper:nth-child(4) .step-wrapper-cta-title"));
        Thread.sleep(4000);
        action.clickElement(Terms);
        action.clickElement(Conditions);
        utils.waitForSeconds();

    }

    public void submitRegistration(String createAccount) {
        action.clickElement(CreateAccountButton);

    }

    public void verifyRegistrationConfirmation(String thankYou) {
        utils.waitForSeconds();
//        if(action.getElementText(RegistrationPage).contains("field is required")){
//            System.out.println(action.getElementText(RegistrationPage));
//        }
        Assert.assertTrue(action.getElementText(RegistrationPage).contains(thankYou));
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("An email has been sent to you to enable you to activate your account. Please click the link in the email to go to the Login Page"));
    }

    public void checkRedirectionToLoginPage() {
        utils.webDriverWaitForVisibilityOfElement(By.cssSelector("a[href='/forgotten-password/']"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-body")).getText().contains("Username"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-body")).getText().contains("Password"));
        Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL + "/login"));
    }

}
