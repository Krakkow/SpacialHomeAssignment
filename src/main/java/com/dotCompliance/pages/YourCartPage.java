package com.dotCompliance.pages;

import org.openqa.selenium.By;

public class YourCartPage {

    private YourCartPage() {
        // Private constructor to prevent instantiation
    }

    public static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");

    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public static final By CHECKOUT_BUTTON = By.id("checkout");
}
