package com.dotCompliance.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.dotCompliance.utils.WebDriverCommonFunc;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverCommonFunc driverUtils;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // ✅ Start Chrome in incognito mode

        // Optional: suppress "Chrome is being controlled" banner
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driverUtils = new WebDriverCommonFunc(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
