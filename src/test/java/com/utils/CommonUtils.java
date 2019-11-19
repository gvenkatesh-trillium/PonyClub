package com.utils;

import com.abstractPages.AbstractMain;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonUtils extends AbstractMain {


    public void waitForSeconds() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void WebDriverWaitForSeconds(){
        WebDriverWait wait=new WebDriverWait(driver, 30);
    }

}
