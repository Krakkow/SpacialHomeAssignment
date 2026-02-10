@ui @smoke
Feature: SauceDemo Cart - State Change

  Scenario: Cart badge updates when adding a product
    Given I navigate to the SauceDemo login page
    When I login using username "standard_user" and password "secret_sauce"
    Then I should land on the Products page
    When I add a product to the cart
    Then the cart badge should show "1"
