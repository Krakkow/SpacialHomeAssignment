package com.dotCompliance.pageutils;

import com.dotCompliance.pages.CommonPageElements;
import com.dotCompliance.pages.ProductsPage;
import com.dotCompliance.utils.WebDriverCommonFunc;

public class ProductPageUtils {

    private WebDriverCommonFunc driverUtils;

    public ProductPageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    /**
     * Currently this class supports adding the first product to the cart.
     * 
     * Future plans:
     * - Support adding a product by name or index.
     * - Possibly return product metadata (name, price, etc.) for further
     * validations.
     */

    public void addFirstItemToCart() {
        driverUtils.click(ProductsPage.FIRST_ADD_TO_CART_BUTTON);
    }

    public void goToCart() {
        driverUtils.click(CommonPageElements.CART_ICON);
    }

    public boolean isProductPageDisplayed() {
        return driverUtils.isVisible(CommonPageElements.PAGE_NAME) &&
                driverUtils.isVisible(ProductsPage.FILTER_DROPDOWN) &&
                driverUtils.isVisible(ProductsPage.INVENTORY_ITEM);
    }

    public boolean waitForPageToLoad() {
        return driverUtils.waitUntilVisible(CommonPageElements.PAGE_NAME).getText().equalsIgnoreCase("Products");
    }

}
