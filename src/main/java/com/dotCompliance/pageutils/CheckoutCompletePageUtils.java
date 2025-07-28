package com.dotCompliance.pageutils;

import com.dotCompliance.pages.CheckoutCompletePage;
import com.dotCompliance.utils.WebDriverCommonFunc;

public class CheckoutCompletePageUtils {

    private WebDriverCommonFunc driverUtils;

    public CheckoutCompletePageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    public boolean isCheckoutCompletePageDisplayed() {
        return driverUtils.isVisible(CheckoutCompletePage.THANK_YOU_MESSAGE_ELEMENT) &&
                driverUtils.isVisible(CheckoutCompletePage.ORDER_CONFIRMATION_MESSAGE_ELEMENT);
    }

    public String getOrderConfirmationMessage() {
        return driverUtils.getTextFromElement(CheckoutCompletePage.ORDER_CONFIRMATION_MESSAGE_ELEMENT);
    }

    public void goToHomePage() {
        driverUtils.click(CheckoutCompletePage.BACK_HOME_BUTTON);
    }

}
