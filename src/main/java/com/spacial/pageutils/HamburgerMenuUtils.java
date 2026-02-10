package com.spacial.pageutils;

import org.openqa.selenium.By;

import com.spacial.pages.CommonPageElements;
import com.spacial.pages.LoginPage;
import com.spacial.utils.WebDriverCommonFunc;

public class HamburgerMenuUtils {

    private WebDriverCommonFunc driverUtils;

    private static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    private static final By logoutLink = By.id("logout_sidebar_link");
    private static final By closeMenuButton = By.id("react-burger-cross-btn"); // exists when menu is open

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

    public void logout() {
        // If menu is not open, open it
        if (!isMenuOpen()) {
            driverUtils.waitUntilClickable(CommonPageElements.HAMBURGER_MENU).click();
            driverUtils.waitUntilVisible(logoutLink);
        }

        // Click logout directly (menu is open at this point)
        driverUtils.waitUntilClickable(logoutLink).click();
    }

    public boolean isOnLoginPage() {
        return driverUtils.doesElementExist(LoginPage.LOGIN_BUTTON);
    }

    private boolean isMenuOpen() {
        return driverUtils.doesElementExist(closeMenuButton);
    }

}
