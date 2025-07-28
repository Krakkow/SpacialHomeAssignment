package com.dotCompliance.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dotCompliance.utils.WebDriverCommonFunc;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverCommonFunc driverUtils;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driverUtils = new WebDriverCommonFunc(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
