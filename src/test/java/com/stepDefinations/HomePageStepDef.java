package com.stepDefinations;

import com.abstractPages.AbstractMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomePageStepDef extends AbstractMain {


    @Given("^I am on home page$")
    public void I_am_on_home_page() throws Throwable {
               homePage.goToHomePage();



    }


    @And("^I see the home page and it looks good$")
    public void iSeeTheHomePageAndItLooksGood() {
        homePage.verifyHeader();
        homePage.verifyFooter();
    }
}
