package com.spacial.pageutils;

import com.spacial.pages.CheckoutOverviewPage;
import com.spacial.utils.WebDriverCommonFunc;

public class CheckoutOverviewPageUtils {

    private WebDriverCommonFunc driverUtils;

    public CheckoutOverviewPageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    public void completeOrder() {
        driverUtils.click(CheckoutOverviewPage.FINISH_BUTTON);
    }

    public void cancelOrder() {
        driverUtils.click(CheckoutOverviewPage.CANCEL_BUTTON);
    }

    public boolean isCheckoutOverviewPageDisplayed() {
        return driverUtils.isVisible(CheckoutOverviewPage.FINISH_BUTTON) &&
                driverUtils.isVisible(CheckoutOverviewPage.CANCEL_BUTTON) &&
                driverUtils.isVisible(CheckoutOverviewPage.TOTAL_PRICE_SUMMARY);
    }

}
