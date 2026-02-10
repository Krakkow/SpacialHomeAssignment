@ui
Feature: SauceDemo Cart and Logout

  Background:
    Given I navigate to the SauceDemo login page
    When I login using username "standard_user" and password "secret_sauce"
    Then I should land on the Products page
    When I reset the application state
    Then the application should be reset

  Scenario: Remove product from cart empties the cart
    When I add a product to the cart
    And I navigate to the Cart page
    And I remove the product from the cart
    Then the cart should be empty

@smoke 
  Scenario: Logout redirects the user to the login page
    When I logout from the application
    Then I should land on the SauceDemo login page
