package com.spacial.pages;

import org.openqa.selenium.By;

public class CheckoutInfoPage {
    private CheckoutInfoPage() {
        // Private constructor to prevent instantiation
    }

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
}
