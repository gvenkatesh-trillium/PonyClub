package com.utils;

import com.abstractPages.AbstractMain;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonUtils extends AbstractMain {


    public void waitForSeconds() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //    public void webDriverWaitForSeconds(){
//        WebDriverWait wait=new WebDriverWait(driver, 30);
//    }
    public void webDriverWaitForVisibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
