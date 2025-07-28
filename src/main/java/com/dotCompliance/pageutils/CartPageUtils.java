package com.dotCompliance.pageutils;

import com.dotCompliance.pages.YourCartPage;
import com.dotCompliance.utils.WebDriverCommonFunc;

public class CartPageUtils {

    private WebDriverCommonFunc driverUtils;

    public CartPageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    public void clickRemoveButton() {
        driverUtils.click(YourCartPage.REMOVE_BUTTON);
    }

    public void clickContinueShoppingButton() {
        driverUtils.click(YourCartPage.CONTINUE_SHOPPING_BUTTON);
    }

    public void clickCheckoutButton() {
        driverUtils.click(YourCartPage.CHECKOUT_BUTTON);
    }

    public boolean isCartPageDisplayed() {
        return driverUtils.isVisible(YourCartPage.REMOVE_BUTTON) &&
                driverUtils.isVisible(YourCartPage.CONTINUE_SHOPPING_BUTTON) &&
                driverUtils.isVisible(YourCartPage.CHECKOUT_BUTTON);
    }

}
