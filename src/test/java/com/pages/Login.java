package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;



public class Login extends AbstractMain {
    public static By LoginPage = By.cssSelector(".main-body");
    public static By SubmitButton = By.cssSelector(".btn_white_to_red");
    public static By CreateAccountButton = By.cssSelector(".downloadsblock-link:nth-child(4) > .button");
    public static By FindBranchButton = By.cssSelector(".downloadsblock-link:nth-child(3) > .button");
    public static By FindOutMoreAboutMembershipButton = By.cssSelector(".promobox-link:nth-child(6) .btn-anim1");
    public static By UsernameBox = By.cssSelector("#Username");
    public static By PasswordBox = By.cssSelector("#Password");
    public static By LoginButton = By.cssSelector(".btn_white_to_red > .btn-anim2");  //Submit button

    public void goToLoginPage() throws InterruptedException {
//        action.clickElement(LoginLink);
        driver.get("https://trillium-interactive-ponyclub-dev.azurewebsites.net/login");
        Thread.sleep(5000);

    }

    public void verifyLoginPage(){
        Assert.assertTrue(action.getElementText(LoginPage).contains("Login"));
        Assert.assertTrue(action.getElementText(LoginPage).contains("Username *"));
        Assert.assertTrue(action.getElementText(LoginPage).contains("Password *"));
        Assert.assertTrue(action.getElementText(LoginPage).contains("Forgot your password"));
        Assert.assertTrue(action.getElementText(LoginPage).contains("Branch Membership"));
        Assert.assertTrue(action.getElementText(LoginPage).contains("Centre Membership"));
        action.isElementPresent(SubmitButton);
        action.isElementPresent(CreateAccountButton);
        action.isElementPresent(FindBranchButton);
        action.isElementPresent(FindOutMoreAboutMembershipButton);
    }

    public void enterLoginDetailsAndLogin(String username, String password) throws InterruptedException {
        action.sendElement(UsernameBox, username);
        action.sendElement(PasswordBox, password);
        Thread.sleep(3000);
        action.clickElement(LoginButton);
        Thread.sleep(10000);
    }
    public void verifyLoggedInPage(){
        Assert.assertTrue(action.getElementText(LoginPage).contains("Connected family"));
        Assert.assertTrue(action.getElementText(Header).contains("Logout"));
        Assert.assertTrue(driver.getCurrentUrl().contains("connected-family"));
    }
}
