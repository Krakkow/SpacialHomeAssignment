package com.dotCompliance.pageutils;

import org.openqa.selenium.By;

import com.dotCompliance.pages.CommonPageElements;
import com.dotCompliance.utils.WebDriverCommonFunc;

public class HamburgerMenuUtils {

    private WebDriverCommonFunc driverUtils;

    private static final By RESET_APP_STATE = By.id("reset_sidebar_link");

    public HamburgerMenuUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    /**
     * Opens the hamburger menu and clicks "Reset App State"
     */
    public void resetAppState() {
        driverUtils.click(CommonPageElements.HAMBURGER_MENU);
        driverUtils.click(RESET_APP_STATE);
    }

    /**
     * Validates cart icon is empty (assumes visible cart badge disappears)
     */
    public boolean isCartReset() {
        // Cart icon badge disappears after reset
        By cartBadge = By.className("shopping_cart_badge");
        return !driverUtils.doesElementExist(cartBadge);
    }

}
