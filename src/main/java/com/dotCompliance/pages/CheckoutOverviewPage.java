package com.dotCompliance.pages;

import org.openqa.selenium.By;

public class CheckoutOverviewPage {

    private CheckoutOverviewPage() {
        // Private constructor to prevent instantiation
    }

    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By TOTAL_PRICE_SUMMARY = By.className("summary_total_label");

}
