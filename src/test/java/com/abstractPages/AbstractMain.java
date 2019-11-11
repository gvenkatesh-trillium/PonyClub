package com.abstractPages;

import com.pages.HomePage;
import com.pages.Login;
import com.pages.RegistrationPage;
import com.pages.SearchPage;
import com.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AbstractMain {

    public static WebDriver driver;
    public static GlobalHooks globalHooks = new GlobalHooks();
    public static Actions action = new Actions();
    public static CommonUtils utils = new CommonUtils();
    public static HomePage homePage = new HomePage();
    public static Login loginPage = new Login();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public static SearchPage searchPage = new SearchPage();

    public static By Header = By.cssSelector(".header");
    public static By Footer = By.cssSelector(".footer");
    public static By LowerFooter = By.className("__lower");




}
