package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;



public class LoginPage extends AbstractMain {
    public static By LoginLink = By.cssSelector(".login__btn");
    public static By LoginPage = By.cssSelector(".main-body");
    public static By SubmitButton = By.cssSelector(".btn_white_to_red");
    public static By CreateAccountButton = By.cssSelector(".downloadsblock-link:nth-child(4) > .button");
    public static By FindBranchButton = By.cssSelector(".downloadsblock-link:nth-child(3) > .button");
    public static By FindOutMoreAboutMembershipButton = By.cssSelector(".promobox-link:nth-child(6) .btn-anim1");

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
}
