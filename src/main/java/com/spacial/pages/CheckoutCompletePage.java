package com.spacial.pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage {
    private CheckoutCompletePage() {
        // Private constructor to prevent instantiation
    }

    public static final By CHECKOUT_COMPLETE_ICON = By.className("pony_express");
    public static final By THANK_YOU_MESSAGE_ELEMENT = By.className("complete-header");
    public static final By ORDER_CONFIRMATION_MESSAGE_ELEMENT = By.className("complete-text");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");

}
