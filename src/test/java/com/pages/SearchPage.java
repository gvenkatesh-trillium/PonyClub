package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPage extends AbstractMain {

    public static By SearchBox = By.cssSelector("#search");
    public static By SearchButton = By.cssSelector("#nav-search > a > div.input-group-append > button > i");
    public static By SearchOverLay = By.cssSelector("#search-overlay.show");
    public static By SearchButtonOnOverlay = By.cssSelector("#search-overlay > div > div > div > button > i");
    public static By SearchOverLayClose = By.cssSelector("#close-search-overlay");
    public static By SearchCount = By.cssSelector(".search-count");


    public void GoToSearchOverLay() throws InterruptedException {
        Assert.assertFalse(action.isElementPresent(SearchOverLay));
        Thread.sleep(3000);
        action.clickElement(SearchButton);
        Thread.sleep(3000);


    }
    public void CheckSearchOverLayDisplayed() throws InterruptedException {
        Assert.assertTrue(action.isElementPresent(SearchOverLay));
        action.clickElement(SearchOverLayClose);
        Assert.assertFalse(action.isElementPresent(SearchOverLay));

    }
    public void SearchKeyWord(String SearchKeyWord){
        action.clickElement(SearchButton);
        action.sendElement(SearchBox, SearchKeyWord);
        action.clickElement(SearchButtonOnOverlay);

    }
    public void CheckSearchResults() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(action.getElementText(SearchCount).contains("results found for article"));
        Thread.sleep(5000);

    }
    public void GoToOneOfTheResultsPage() throws InterruptedException {
        action.clickElement(By.cssSelector("div.component.search-results > div > div > div:nth-child(1) > div > a"));
        Thread.sleep(5000);
    }
    public void GoToResultsPage() throws InterruptedException {
        Assert.assertFalse(action.getElementText(By.cssSelector("#content")).contains("Search results"));
        Assert.assertFalse(action.getElementText(By.cssSelector("#content")).contains("results found for article"));

    }

}
