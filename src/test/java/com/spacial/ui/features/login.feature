@ui
Feature: Login
  As a user
  I want to log into SauceDemo
  So that I can access the inventory page

  @smoke
  Scenario: Successful login with a valid user
    Given I navigate to the SauceDemo login page
    When I login using username "standard_user" and password "secret_sauce"
    Then I should land on the Products page
