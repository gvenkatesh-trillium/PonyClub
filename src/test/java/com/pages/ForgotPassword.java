package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import static com.pages.Login.ForgotPasswordLink;


public class ForgotPassword extends AbstractMain {
    public static By ForgotPasswordPage = By.cssSelector("div.main-body");
    public static By eMail = By.cssSelector("#Email");
    public static By ForgotPasswordSubmitButton = By.cssSelector("span.btn-anim2");



    public void gotoForgotPasswordPage(String forgotPasswordLink)  {
                action.clickElement(ForgotPasswordLink);
    }

    public void verifyForgotPasswordPage(String forgotPasswordpage)throws InterruptedException{
                Thread.sleep(5000);
                Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains(forgotPasswordpage));
                Assert.assertTrue(driver.getCurrentUrl().contains("forgotten-password"));
    }

    public void enterValidEmailAndSubmit(String email, String submitButton) throws InterruptedException {

        action.sendElement(eMail, email);
        Thread.sleep(2000);
        action.clickElement(ForgotPasswordSubmitButton);

    }
    public void verifyForgotPasswordSubmit() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("We have sent an email to your provided address. When you receive it, please click on the link contained in it and you will be able to set a new Password."));
        Thread.sleep(10000);
    }

    public void resetPasswordFromResetLinkInEmail() throws InterruptedException {
        driver.get("https://mail.protonmail.com/login");
        Thread.sleep(5000);
        action.sendElement(By.cssSelector("#username"), "TrilliumEmailTest");
        action.sendElement(By.cssSelector("#password"), "Password123");
        action.clickElement(By.cssSelector("#login_btn"));
        Thread.sleep(10000);
        action.clickElement(By.cssSelector(".marked .subject-text"));
        Thread.sleep(5000);
        action.clickElement(By.cssSelector("a[href*='u2564215.ct.sendgrid.net/wf/click']"));
        Thread.sleep(5000);

    }

    public void goToResetPasswordPage() throws InterruptedException {
        Thread.sleep(10000);
        //Switch tab
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(0));
//        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Reset Password"));
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Password *"));
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Confirm Password *"));
        Assert.assertTrue(driver.getTitle().contains("Reset Password - Pony Club"));

    }
    public void enterValidPasswordAndSubmit(String resetPasswordSubmitButton) throws InterruptedException {

        action.sendElement(By.cssSelector("#Password"), "Password123");
        action.sendElement(By.cssSelector("#ConfirmPassword"), "Password123");
        Thread.sleep(5000);
        action.clickElement(By.cssSelector( ".btn-anim2"));
    }
    public void ResetPasswordConfirmation() throws InterruptedException {

        Thread.sleep(5000);
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Your password has been successfully changed."));


    }




}
