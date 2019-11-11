package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends AbstractMain {

    public static String BASE_URL = "https://trillium-interactive-ponyclub-dev.azurewebsites.net";
    public static By Cookie = By.cssSelector(".cookie__btn");
    public String Title = "Trillium1";


    public void goToHomePage() throws InterruptedException {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),Title);   // Check Title displayed
        Thread.sleep(5000);
//        action.clickElement(Cookie);                    // accept cookies
        Thread.sleep(5000);

    }

    public void verifyHeader(){
        action.isElementPresent(Header);       //Check Header displayed


    }
    public void verifyFooter(){
        action.isElementPresent(Footer);          // Check footer displayed
        action.isElementPresent(LowerFooter);




    }


}
