package com.spacial.ui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/spacial/ui/features", glue = { "com.spacial.ui.stepDefinitions",
        "com.spacial.ui.hooks" }, plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        }, monochrome = true
// tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
