package com.abstractPages;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.pages.SearchPage;
import com.utils.CommonUtils;
import org.openqa.selenium.WebDriver;



public class AbstractMain {

    public static WebDriver driver;
//    public String email ="";
    public static GlobalHooks globalHooks = new GlobalHooks();
    public static Actions action = new Actions();
    public static CommonUtils utils = new CommonUtils();
    public static HomePage homePage = new HomePage();
    public static LoginPage loginPage = new LoginPage();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public static SearchPage searchPage = new SearchPage();




}
