package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;

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

    }

    public void resetPasswordFromResetLinkInEmail() throws InterruptedException {
        driver.get("https://mail.protonmail.com/login");
        Thread.sleep(5000);
        action.sendElement(By.cssSelector("#username"), "TrilliumEmailTest");
        action.sendElement(By.cssSelector("#password"), "Password123");
        action.clickElement(By.cssSelector("#login_btn"));
        Thread.sleep(5000);
        action.clickElement(By.cssSelector("#conversation-list-columns > section > div.conversation.marked.hasLabels > div.conversation-meta > div.row.top > h4 > span.subject-text.ellipsis"));
        Thread.sleep(5000);
        action.clickElement(By.cssSelector("a[href*='u2564215.ct.sendgrid.net/wf/click']"));
        Thread.sleep(5000);




    }
}
