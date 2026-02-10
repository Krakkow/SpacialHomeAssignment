package com.spacial.ui.stepDefinitions;

import com.spacial.pageutils.*;
import com.spacial.pages.LoginPage;
import com.spacial.pages.YourCartPage;
import com.spacial.ui.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import java.util.List;

public class UserLoginE2ESteps {

    private static final String DEFAULT_UI_BASE_URL = "https://www.saucedemo.com/";

    // Page Utils
    private final LoginPageUtils loginPage = new LoginPageUtils(Hooks.driverUtils);
    private final ProductPageUtils productPage = new ProductPageUtils(Hooks.driverUtils);
    private final CartPageUtils cartPage = new CartPageUtils(Hooks.driverUtils);
    private final CheckoutInfoPageUtils checkoutInfoPage = new CheckoutInfoPageUtils(Hooks.driverUtils);
    private final CheckoutOverviewPageUtils checkoutOverviewPage = new CheckoutOverviewPageUtils(Hooks.driverUtils);
    private final CheckoutCompletePageUtils checkoutCompletePage = new CheckoutCompletePageUtils(Hooks.driverUtils);
    private final HamburgerMenuUtils hamburgerMenu = new HamburgerMenuUtils(Hooks.driverUtils);

    // ---------------------------
    // Common / Navigation steps
    // ---------------------------

    @Given("I navigate to the SauceDemo login page")
    public void i_navigate_to_login_page() {
        // Allows override in CI: -Dui.baseUrl=https://www.saucedemo.com/
        String baseUrl = System.getProperty("ui.baseUrl", DEFAULT_UI_BASE_URL);
        loginPage.goToLoginPage(baseUrl);

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "Login page was not displayed. Current URL: " + Hooks.driverUtils.getCurrentUrl());
    }

    @When("I login using username {string} and password {string}")
    public void i_login_with_credentials(String username, String password) {
        loginPage.fillLoginForm(username, password);
        loginPage.clickLoginButton();
    }

    @Then("I should land on the Products page")
    public void i_should_land_on_products_page() {
        Assert.assertTrue(productPage.waitForPageToLoad(),
                "Products page did not load. Current URL: " + Hooks.driverUtils.getCurrentUrl());
    }

    @Then("I should land on the SauceDemo login page")
    public void i_should_land_on_the_saucedemo_login_page() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "Expected to be on login page, but it was not displayed. Current URL: "
                        + Hooks.driverUtils.getCurrentUrl());
    }

    // ---------------------------
    // Negative login
    // ---------------------------

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
        Assert.assertTrue(Hooks.driverUtils.isVisible(LoginPage.LOGIN_ERROR_MESSAGE),
                "Expected a login error message, but it was not displayed.");
        String msg = Hooks.driverUtils.getTextFromElement(LoginPage.LOGIN_ERROR_MESSAGE);
        Assert.assertTrue(msg != null && !msg.trim().isEmpty(),
                "Login error message is displayed but empty.");
    }

    // ---------------------------
    // Cart - State change
    // ---------------------------

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        productPage.addFirstItemToCart();
    }

    @Then("the cart badge should show {string}")
    public void the_cart_badge_should_show(String expectedCount) {
        Assert.assertTrue(Hooks.driverUtils.doesElementExist(YourCartPage.CART_BADGE),
                "Cart badge was not displayed after adding an item.");

        String badgeText = Hooks.driverUtils.getTextFromElement(YourCartPage.CART_BADGE);
        Assert.assertEquals(badgeText.trim(), expectedCount.trim(),
                "Cart badge count mismatch.");
    }

    @When("I navigate to the Cart page")
    public void i_navigate_to_the_cart_page() {
        productPage.goToCart();

        // If cart has an item, your existing cartPage.isCartPageDisplayed() is OK.
        // If cart is empty, REMOVE button won't exist — so we use a fallback container
        // check too.
        boolean cartLoaded = Hooks.driverUtils.doesElementExist(YourCartPage.CART_LIST_CONTAINER)
                || cartPage.isCartPageDisplayed();
        Assert.assertTrue(cartLoaded,
                "Cart page did not load. Current URL: " + Hooks.driverUtils.getCurrentUrl());
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        cartPage.clickRemoveButton();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        List<?> items = Hooks.driverUtils.findElements(YourCartPage.CART_ITEMS);
        Assert.assertTrue(items.isEmpty(), "Expected cart to be empty, but found items in the cart.");
    }

    // ---------------------------
    // Logout
    // ---------------------------

    @When("I logout from the application")
    public void i_logout_from_the_application() {
        hamburgerMenu.logout();
    }

    // ---------------------------
    // Existing E2E steps (kept intact, but CI-safe asserts)
    // ---------------------------

    @When("I add a product to the cart and proceed to checkout")
    public void i_add_product_and_proceed_to_checkout() {
        productPage.addFirstItemToCart();
        productPage.goToCart();

        Assert.assertTrue(cartPage.isCartPageDisplayed(),
                "Cart page did not display (expected after adding an item).");

        cartPage.clickCheckoutButton();
    }

    @When("I fill in the checkout information")
    public void i_fill_checkout_info() {
        // Keep static data for now (can later be moved to config/test data)
        checkoutInfoPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutInfoPage.clickContinueButton();
    }

    @When("I finish the checkout process")
    public void i_finish_checkout() {
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed(),
                "Checkout Overview page was not displayed.");

        checkoutOverviewPage.completeOrder();
    }

    @Then("I should land on the Checkout Complete page")
    public void i_should_land_on_complete_page() {
        Assert.assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed(),
                "Checkout Complete page was not displayed.");

        // Your flow returns to home page after confirmation
        checkoutCompletePage.goToHomePage();
    }

    @When("I reset the application state")
    public void i_reset_app_state() {
        hamburgerMenu.resetAppState();
    }

    @Then("the application should be reset")
    public void i_verify_app_state_reset() {
        Assert.assertTrue(hamburgerMenu.isCartReset(),
                "Application was not reset (cart badge still exists).");
    }
}
