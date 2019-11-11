package com.stepDefinations;

import com.abstractPages.AbstractMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageStepDef extends AbstractMain {

        @Given("^I go to login page$")
    public void I_go_to_login_page() throws Throwable {
        loginPage.goToLoginPage();

    }

    @And("^I should see Login page$")
    public void I_should_see_Login_page() throws Throwable {
        loginPage.verifyLoginPage();
    }

    @Given("^I enter valid login details, username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void i_enter_valid_login_details_username_as_and_password_as(String username, String password) throws Throwable {
        loginPage.enterLoginDetailsAndLogin(username, password);

    }

    @Then("^login must be successful\\.$")
    public void login_must_be_successful() throws Throwable {
        loginPage.verifyLoggedInPage();

    }
}
