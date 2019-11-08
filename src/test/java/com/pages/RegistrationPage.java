package com.pages;



import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


import com.abstractPages.AbstractMain;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractMain {

    public static By CreateAnAccountLink = By.cssSelector("a[href='/registration']");
    public static By RegistrationPage = By.cssSelector(".content-inner");
    public static By FirstName = By.cssSelector("#FirstName");
    public static By LastName = By.cssSelector("#LastName");
    public static By PreferredName = By.cssSelector("#PreferredName");
    public static By eMail = By.cssSelector("#Email");
    public static By Password = By.cssSelector("#Password");
    public static By ConfirmPassword = By.cssSelector("#ConfirmPassword");
    public static By SubmitButton = By.cssSelector("button.btn.btn--tertiary.loading-component-hide-on-loading-helper");

    public void getTempEmailAddress(){

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://10minutemail.net/");
//        email = driver.findElement(By.className("mailtext")).getAttribute("value");
    }

    public void goToRegistrationPage() throws InterruptedException {
        action.clickElement(CreateAnAccountLink);
        Thread.sleep(5000);

    }

    public void verifyRegistrationPage() throws InterruptedException {
        Assert.assertTrue(action.getElementText(RegistrationPage).contains("Registration"));
        Assert.assertTrue(driver.getTitle().contains("Registration"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/registration"));
    }

    public void enterRegistrationDetails(DataTable data) throws InterruptedException {
//        WebElement TitledrpDwnList4 = driver.findElement(By.cssSelector("#SelectedTitle"));
//        Select TitleobjSel4 = new Select(TitledrpDwnList4);
//        List <WebElement> Titleweblist4 = TitleobjSel4.getOptions();
//        int TitleiCnt4 = Titleweblist4.size();
//        Random Titlenum4 = new Random();
//        int TitleiSelect4 = Titlenum4.nextInt(TitleiCnt4);
//        while(TitleiSelect4 == 0){TitleiSelect4 = Titlenum4.nextInt(TitleiCnt4);
//            if(TitleiSelect4 != 0){break;}}
//        TitleobjSel4.selectByIndex(TitleiSelect4);
        driver.findElement(By.cssSelector(".combo-arrow")).click();
        List<WebElement> itemsInDropdown = driver.findElements(By.cssSelector(".combo-dropdown"));
        int size = itemsInDropdown.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
        Thread.sleep(2000);
        itemsInDropdown.get(randomNumber).click();
        Thread.sleep(5000);






        List<Map<String, String>> list = data.asMaps(String.class, String.class);
        action.sendElement(FirstName, list.get(0).get("FirstName"));
        action.sendElement(LastName, list.get(0).get("LastName"));
        action.sendElement(PreferredName, list.get(0).get("PreferredName"));
        Random rn = new Random();
        int email = rn.nextInt(1000000) + 10;
        action.sendElement(eMail, Integer.toString(email)+"@mailnow2.com");
        System.out.println(Integer.toString(email)+"@mailnow2.com");
        action.clickElement(By.cssSelector("#DateOfBirth"));
        Thread.sleep(5000);
        action.clickElement(By.cssSelector("body > div.datepicker-container.datepicker-dropdown.datepicker-top-left > div:nth-child(1) > ul:nth-child(2) > li:nth-child(4)"));
        Thread.sleep(5000);
        action.clickElement(eMail);
        Thread.sleep(5000);
        action.sendElement(Password, list.get(0).get("Password"));
        action.sendElement(ConfirmPassword, list.get(0).get("ConfirmPassword"));
                Thread.sleep(5000);
    }
    public void submitTheRegistrationForm() throws InterruptedException {
        action.clickElement(SubmitButton);
        Thread.sleep(10000);
    }
    public void verifyRegistration(String confirmationMsg){
        Assert.assertTrue(action.getElementText(RegistrationPage).contains(confirmationMsg));

    }


}
