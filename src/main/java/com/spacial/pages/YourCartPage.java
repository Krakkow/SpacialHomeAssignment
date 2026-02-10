package com.spacial.pages;

import org.openqa.selenium.By;

public class YourCartPage {

    private YourCartPage() {
        // Private constructor to prevent instantiation
    }

    public static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");

    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public static final By CHECKOUT_BUTTON = By.id("checkout");

    public static final By CART_ITEMS = By.cssSelector(".cart_item");

    public static final By CART_BADGE = By.className("shopping_cart_badge");

    public static final By CART_LIST_CONTAINER = By.cssSelector(".cart_list");
}
