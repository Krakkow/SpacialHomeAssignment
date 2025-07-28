package com.dotCompliance.pages;

import org.openqa.selenium.By;

public class CommonPageElements {

    private CommonPageElements() {
        // Private constructor to prevent instantiation
    }

    // Common elements across multiple pages
    public static final By PAGE_MAIN_TITLE = By.className("app_logo");
    public static final By PAGE_NAME = By.className("title");
    public static final By CART_ICON = By.className("shopping_cart_link");
    public static final By HAMBURGER_MENU = By.id("react-burger-menu-btn");
    public static final By PRODUCT_NAMES = By.className("inventory_item_name");
    public static final By PRODUCT_PRICES = By.className("inventory_item_price");
    public static final By PRODUCT_DESCRIPTIONS = By.className("inventory_item_desc");
    public static final By CART_QUANTITY = By.cssSelector("[data-test='inventory-item'] > [data-test='item-quantity']");

    // Social media icons in the footer
    public static final By TWITTER_ICON = By.cssSelector("a[href*='twitter']");
    public static final By FACEBOOK_ICON = By.cssSelector("a[href*='facebook']");
    public static final By LINKEDIN_ICON = By.cssSelector("a[href*='linkedin']");
}
