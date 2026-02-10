package com.spacial.pageutils;

import com.spacial.pages.CheckoutInfoPage;
import com.spacial.utils.WebDriverCommonFunc;

public class CheckoutInfoPageUtils {
    private WebDriverCommonFunc driverUtils;

    public CheckoutInfoPageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        driverUtils.type(CheckoutInfoPage.FIRST_NAME_INPUT, firstName);
        driverUtils.type(CheckoutInfoPage.LAST_NAME_INPUT, lastName);
        driverUtils.type(CheckoutInfoPage.POSTAL_CODE_INPUT, postalCode);
    }

    public void clickContinueButton() {
        driverUtils.click(CheckoutInfoPage.CONTINUE_BUTTON);
    }

    public void clickCancelButton() {
        driverUtils.click(CheckoutInfoPage.CANCEL_BUTTON);
    }

    public boolean isCheckoutInfoPageDisplayed() {
        return driverUtils.isVisible(CheckoutInfoPage.FIRST_NAME_INPUT) &&
                driverUtils.isVisible(CheckoutInfoPage.LAST_NAME_INPUT) &&
                driverUtils.isVisible(CheckoutInfoPage.POSTAL_CODE_INPUT) &&
                driverUtils.isVisible(CheckoutInfoPage.CONTINUE_BUTTON);
    }
}
