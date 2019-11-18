package com.stepDefinations;

import com.abstractPages.AbstractMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ForgotPasswordStepDef extends AbstractMain {


    @And("^I should see the \"([^\"]*)\" link$")
    public void i_should_see_the_forgotPassword_link(String forgotPasswordLink) throws Throwable {
        loginPage.verifyLoginPage();
    }

    @And("^I click on \"([^\"]*)\" link$")
    public void i_click_on_ForgotPassword_link(String forgotPasswordLink) throws Throwable {
        forgotPassword.gotoForgotPasswordPage(forgotPasswordLink);
    }

    @And("^I should see the \"([^\"]*)\" page$")
    public void i_should_see_the_forgotPassword_page(String forgotPasswordPage) throws Throwable {
        forgotPassword.verifyForgotPasswordPage(forgotPasswordPage);

    }

    @And("^I enter valid username as \"([^\"]*)\" and I click (.+) button$")
    public void i_enter_valid_username_and_i_click_submit_button(String email, String submitButton) throws Throwable {
        forgotPassword.enterValidEmailAndSubmit(email, submitButton);
    }

    @Then("^I should see eMail sent message$")
    public void i_should_see_email_sent_message() throws Throwable {
        forgotPassword.verifyForgotPasswordSubmit();

    }
    @And("^I go to my inbox and click on reset password link$")
    public void i_go_to_my_inbox_and_click_on_reset_password_link() throws Throwable {
        forgotPassword.resetPasswordFromResetLinkInEmail();

    }

    @And("^I should see reset password page$")
    public void i_should_see_reset_password_page() throws Throwable {
        forgotPassword.goToResetPasswordPage();

    }

    @And("^I enter new password and click (.+)$")
    public void i_enter_new_password_and_click_submitButton(String resetPasswordSubmitButton) throws Throwable {
        forgotPassword.enterValidPasswordAndSubmit(resetPasswordSubmitButton);

    }
    @Then("^I should see message \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_should_see_message_thankYou(String strArg1, String strArg2) throws Throwable {
        forgotPassword.ResetPasswordConfirmation();

    }



}
