package com.dotCompliance.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/dotCompliance/features", glue = { "com.dotCompliance.stepDefinitions",
        "com.dotCompliance.hooks" }, plugin = { "pretty",
                "html:target/cucumber-reports.html" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
