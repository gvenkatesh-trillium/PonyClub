package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.NoSuchElementException;

import static com.pages.Login.ForgotPasswordLink;


public class ForgotPassword extends AbstractMain {
    public static By ForgotPasswordPage = By.cssSelector("div.main-body");
    public static By eMail = By.cssSelector("#Email");
    public static By ForgotPasswordSubmitButton = By.cssSelector("span.btn-anim2");



    public void gotoForgotPasswordPage(String forgotPasswordLink)  {
                action.clickElement(ForgotPasswordLink);
    }

    public void verifyForgotPasswordPage(String forgotPasswordpage)throws InterruptedException{
        utils.waitForSeconds();
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains(forgotPasswordpage));
        Assert.assertTrue(driver.getCurrentUrl().contains("forgotten-password"));
    }

    public void enterValidEmailAndSubmit(String email, String submitButton) throws InterruptedException {

        action.sendElement(eMail, email);
        utils.waitForSeconds();
        action.clickElement(ForgotPasswordSubmitButton);

    }
    public void verifyForgotPasswordSubmit() throws InterruptedException {
        utils.waitForSeconds();
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("We have sent an email to your provided address. When you receive it, please click on the link contained in it and you will be able to set a new Password."));
        utils.waitForSeconds();
    }

    public void resetPasswordFromResetLinkInEmail() throws InterruptedException {
        driver.get("https://mail.protonmail.com/login");
        utils.waitForSeconds();
        action.sendElement(By.cssSelector("#username"), "TrilliumEmailTest");
        action.sendElement(By.cssSelector("#password"), "Password123");
        action.clickElement(By.cssSelector("#login_btn"));
        utils.waitForSeconds();
        action.clickElement(By.cssSelector(".marked .subject-text"));
        utils.waitForSeconds();
        action.clickElement(By.cssSelector("a[href*='u2564215.ct.sendgrid.net/wf/click']"));
        utils.waitForSeconds();
        //Switch tab
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        utils.waitForSeconds();

        if(driver.findElement(ForgotPasswordPage).getText().contains("The reset link has expired. Please request a new one"))

            try{
            for (int i = 1; i <= 5; i++) {
                driver.switchTo().window(tabs2.get(1));
//                driver.close();
                utils.waitForSeconds();
                driver.switchTo().window(tabs2.get(0));
                System.out.println("Refreshing eMail - " + i);
                utils.waitForSeconds();
                action.clickElement(By.cssSelector(".active .navigationItem-title"));
                utils.waitForSeconds();
                action.clickElement(By.cssSelector(".marked .subject-text"));
                utils.waitForSeconds();
                action.clickElement(By.cssSelector("a[href*='u2564215.ct.sendgrid.net/wf/click']"));
                utils.waitForSeconds();
                if(!driver.findElement(ForgotPasswordPage).getText().contains("The reset link has expired. Please request a new one")){
                    break;
                }

            }}
        catch (NoSuchElementException ne){
            System.out.println("Exception = no such element at line number 76(on if condition)");
        }



    }

    public void goToResetPasswordPage()  {
        Assert.assertTrue(driver.getTitle().contains("Reset Password - Pony Club"));
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Reset Password"));
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Password *"));
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Confirm Password *"));

    }
    public void enterValidPasswordAndSubmit(String resetPasswordSubmitButton) throws InterruptedException {

        action.sendElement(By.cssSelector("#Password"), "Password123");
        action.sendElement(By.cssSelector("#ConfirmPassword"), "Password123");
        utils.waitForSeconds();
        action.clickElement(By.cssSelector(".btn-anim2"));
    }
    public void ResetPasswordConfirmation() throws InterruptedException {

        utils.waitForSeconds();
        Assert.assertTrue(action.getElementText(ForgotPasswordPage).contains("Your password has been successfully changed."));


    }




}
