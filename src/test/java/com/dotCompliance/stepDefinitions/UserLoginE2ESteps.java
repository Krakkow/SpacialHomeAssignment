package com.dotCompliance.stepDefinitions;

import com.dotCompliance.hooks.Hooks;
import com.dotCompliance.pageutils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class UserLoginE2ESteps {

    LoginPageUtils loginPage = new LoginPageUtils(Hooks.driverUtils);
    ProductPageUtils productPage = new ProductPageUtils(Hooks.driverUtils);
    CartPageUtils cartPage = new CartPageUtils(Hooks.driverUtils);
    CheckoutInfoPageUtils checkoutInfoPage = new CheckoutInfoPageUtils(Hooks.driverUtils);
    CheckoutOverviewPageUtils checkoutOverviewPage = new CheckoutOverviewPageUtils(Hooks.driverUtils);
    CheckoutCompletePageUtils checkoutCompletePage = new CheckoutCompletePageUtils(Hooks.driverUtils);
    HamburgerMenuUtils hamburgerMenu = new HamburgerMenuUtils(Hooks.driverUtils);

    @Given("I navigate to the SauceDemo login page")
    public void i_navigate_to_login_page() {
        loginPage.goToLoginPage("https://www.saucedemo.com/");
    }

    @When("I login using username {string} and password {string}")
    public void i_login_with_credentials(String username, String password) {
        loginPage.fillLoginForm(username, password);
        loginPage.clickLoginButton();
    }

    @Then("I should land on the Products page")
    public void i_should_land_on_products_page() {
        assert productPage.waitForPageToLoad();
    }

    @When("I add a product to the cart and proceed to checkout")
    public void i_add_product_and_proceed_to_checkout() {
        productPage.addFirstItemToCart();
        productPage.goToCart();
        assert cartPage.isCartPageDisplayed();
        cartPage.clickCheckoutButton();
    }

    @When("I fill in the checkout information")
    public void i_fill_checkout_info() {
        checkoutInfoPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutInfoPage.clickContinueButton();
    }

    @When("I finish the checkout process")
    public void i_finish_checkout() {
        assert checkoutOverviewPage.isCheckoutOverviewPageDisplayed();
        checkoutOverviewPage.completeOrder();
    }

    @Then("I should land on the Checkout Complete page")
    public void i_should_land_on_complete_page() {
        assert checkoutCompletePage.isCheckoutCompletePageDisplayed();
        checkoutCompletePage.goToHomePage();
    }

    @When("I reset the application state")
    public void i_reset_app_state() {
        hamburgerMenu.resetAppState();
    }

    @Then("the application should be reset")
    public void i_verify_app_state_reset() {
        assert hamburgerMenu.isCartReset();
    }
}
