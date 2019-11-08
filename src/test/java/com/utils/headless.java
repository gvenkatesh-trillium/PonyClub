package com.utils;

import com.abstractPages.AbstractMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class headless extends AbstractMain {
    public static void main(String[] args) throws InterruptedException {
        test();

    }

    public static void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver();


        driver.get("https://temp-mail.org/en/change");
        driver.findElement(By.cssSelector("#new_mail")).sendKeys("316548");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#postbut")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".viewLink.title-subject")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href*='.wsetglobal.com/wf/click']")).click();



//        Random rn = new Random();
//        int email = rn.nextInt(1000000) + 10;
//        System.out.println(email);

    }
}
