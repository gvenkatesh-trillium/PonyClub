package com.pages;

import com.abstractPages.AbstractMain;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends AbstractMain {
    public static By Cookie = By.cssSelector(".cookie__btn");
    public String Title = "Login";


    public void goToHomePage() throws InterruptedException {

        driver.get(BASE_URL);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), Title);   // Check Title displayed
        utils.waitForSeconds();
//        action.clickElement(Cookie);                    // accept cookies
        globalHooks.scenario.write("No Cookies message displayed ");
        utils.waitForSeconds();

    }

    public void verifyHeader(){
        action.isElementPresent(Header);       //Check Header displayed


    }
    public void verifyFooter(){
        action.isElementPresent(Footer);          // Check footer displayed
        action.isElementPresent(LowerFooter);




    }


}
