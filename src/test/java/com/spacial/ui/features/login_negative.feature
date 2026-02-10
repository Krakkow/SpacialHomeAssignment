@ui @negative
Feature: SauceDemo Login - Negative Cases

  Scenario: Login fails with invalid credentials
    Given I navigate to the SauceDemo login page
    When I login using username "invalid_user" and password "wrong_password"
    Then I should see a login error message
