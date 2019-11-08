package com.abstractPages;

import org.openqa.selenium.By;

public class Actions extends AbstractMain {


    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public void clickElements(By element, int index) {
        driver.findElements(element).get(index).click();
    }

    public void sendElement(By element, String keysToSend) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(keysToSend);
    }

    public boolean isElementPresent(By element) {
        int elementSize = driver.findElements(element).size();
        if (elementSize >= 1) {
            return true;
        }
        return false;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    public String getElementAttribute(By element) {
        return driver.findElement(element).getAttribute("text");
    }


}
