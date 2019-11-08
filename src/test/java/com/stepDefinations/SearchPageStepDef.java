package com.stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.abstractPages.AbstractMain.searchPage;

public class SearchPageStepDef {

    @And("^I Click on the search icon$")
    public void i_click_on_the_search_icon() throws Throwable {
        searchPage.GoToSearchOverLay();
    }

    @Then("^I should see Search Overlay$")
    public void i_should_see_search_overlay() throws Throwable {
        searchPage.CheckSearchOverLayDisplayed();
    }
    @And("^I want to search for \"([^\"]*)\" keyword$")
    public void i_want_to_search_for_something_keyword(String SearchKeyWord) throws Throwable {
        searchPage.SearchKeyWord(SearchKeyWord);
    }
    @Then("^I should see Search results for \"([^\"]*)\" keyword$")
    public void i_should_see_search_results_for_something_keyword(String SearchKeyWord) throws Throwable {
        searchPage.CheckSearchResults();
    }

    @And("^I click on one of the article from search results list$")
    public void i_click_on_one_of_the_article_from_search_results() throws Throwable {
        searchPage.GoToOneOfTheResultsPage();
    }
    @Then("^I should be able to navigate to relevant article page$")
    public void i_should_be_able_to_navigate_to_relevant_article_page() throws Throwable {
        searchPage.GoToResultsPage();
    }




}
