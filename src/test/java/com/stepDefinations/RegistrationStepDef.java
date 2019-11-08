package com.stepDefinations;

import com.abstractPages.AbstractMain;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RegistrationStepDef extends AbstractMain {

    @And("^I should be able to see Login page with link to Create an account$")
    public void i_should_be_able_to_see_Login_page_with_link_to_Create_an_account() throws Throwable {
        loginPage.verifyLoginPage();

    }

    @And("^I will click on Crate an account link$")
    public void i_will_click_on_Crate_an_account_link() throws Throwable {
//        registrationPage.getTempEmailAddress();
        registrationPage.goToRegistrationPage();

    }

    @And("^I should see Registration form page$")
    public void i_should_see_Registration_form_page() throws Throwable {
        registrationPage.verifyRegistrationPage();

    }

    @And("^I enter the following details$")
    public void i_enter_the_following_details(DataTable data) throws Throwable {
        registrationPage.enterRegistrationDetails(data);


    }

    @And("^I click \"([^\"]*)\" button$")
    public void i_click_button(String arg1) throws Throwable {
        registrationPage.submitTheRegistrationForm();

    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void i_should_see_message(String confirmationMsg) throws Throwable {
        registrationPage.verifyRegistration(confirmationMsg);

    }

}


