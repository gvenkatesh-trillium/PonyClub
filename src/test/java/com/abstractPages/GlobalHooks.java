package com.abstractPages;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GlobalHooks extends AbstractMain {

   @Before
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
//       ChromeOptions options = new ChromeOptions();
//       options.addArguments("disable-infobars");
//       options.addArguments("test-type");
//       options.addArguments("allow-running-insecure-content");
//       options.setHeadless(true);
//       DesiredCapabilities caps = DesiredCapabilities.chrome();
//       caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//       caps.setCapability(ChromeOptions.CAPABILITY, options);
//       driver = new ChromeDriver(options);
       driver = new ChromeDriver();
    }
    @After
    public void endTest(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }

      driver.quit();


    }

}
