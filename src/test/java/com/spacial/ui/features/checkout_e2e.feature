@ui @smoke @e2e
Feature: SauceDemo Standard User E2E Flow


  Scenario Outline: E2E checkout flow for valid users
    Given I navigate to the SauceDemo login page
    When I login using username "<username>" and password "<password>"
    Then I should land on the Products page
    When I add a product to the cart and proceed to checkout
    And I fill in the checkout information
    And I finish the checkout process
    Then I should land on the Checkout Complete page
    When I reset the application state
    Then the application should be reset

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |
