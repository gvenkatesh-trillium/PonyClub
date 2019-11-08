package com.stepDefinations;

import com.abstractPages.AbstractMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginPageStepDef extends AbstractMain {

        @Given("^I go to login page$")
    public void I_go_to_login_page() throws Throwable {
        loginPage.goToLoginPage();

    }

    @And("^I should see Login page$")
    public void I_should_see_Login_page() throws Throwable {
        loginPage.verifyLoginPage();

    }
}
