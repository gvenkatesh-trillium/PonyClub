package com.cucumberRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


import java.io.File;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml"},
        features = {"./src/test/java/featuresFiles"},
        glue = {"com.stepDefinations", "com.abstractPages"})
class TestRunner {


}