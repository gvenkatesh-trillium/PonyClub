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

    @And("^I will click on (.+) button in login page$")
    public void i_will_click_on_button_in_login_page(String createAnAccount) throws Throwable {
        registrationPage.goToRegistrationPage(createAnAccount);

    }

    @And("^I should see Registration form page$")
    public void i_should_see_Registration_form_page() throws Throwable {
        registrationPage.verifyRegistrationPage();
    }

    @And("^I enter the following personal details$")
    public void i_enter_the_following_details(DataTable personalDetails) throws Throwable {
        registrationPage.enterPersonalDetails(personalDetails);


    }

    @And("^I select following address from dropdown or enter the address manually if loqate service is not available$")
    public void i_select_following_address_from_dropdown_or_enter_the_address_manually_if_loqate_service_is_not_available(DataTable address) throws Throwable {
        registrationPage.enterAddressDetails(address);

    }

    @And("^I enter the following details account details$")
    public void i_enter_the_following_details_account_details(DataTable account) throws Throwable {
        registrationPage.enterAccountDetails(account);
    }

    @And("^I accept Terms & Conditions$")
    public void i_accept_terms_conditions() throws Throwable {
        registrationPage.acceptTermsAndConditions();
    }
    @And("^I click (.+) button to submit the form$")
    public void i_click_button_to_submit_the_form(String createAccount) throws Throwable {
        registrationPage.submitRegistration(createAccount);
    }

    @Then("^I should see \"([^\"]*)\" and activate yor account message$")
    public void i_should_see_something_and_activate_yor_account_message(String thankYou) throws Throwable {
        registrationPage.verifyRegistrationConfirmation(thankYou);

    }
    @Then("^I should be redirected to login page automatically$")
    public void i_should_be_redirected_to_login_page_automatically() throws InterruptedException {
        registrationPage.checkRedirectionToLoginPage();

    }




}


