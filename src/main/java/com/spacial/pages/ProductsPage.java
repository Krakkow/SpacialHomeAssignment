package com.spacial.pages;

import org.openqa.selenium.By;

public class ProductsPage {

    private ProductsPage() {
        // Private constructor to prevent instantiation
    }

    // Filter dropdown
    public static final By FILTER_DROPDOWN = By.className("product_sort_container");

    // List of all inventory items
    public static final By INVENTORY_ITEM = By
            .cssSelector("[data-test='inventory-list'] > [data-test='inventory-item']");

    // List of all product images
    public static final By PRODUCT_IMAGES = By.className("inventory_item_img");

    // Add to cart button for first product (can generalize later)
    public static final By FIRST_ADD_TO_CART_BUTTON = By.xpath("(//button[contains(text(),'Add to cart')])[1]");

    public static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");

}
