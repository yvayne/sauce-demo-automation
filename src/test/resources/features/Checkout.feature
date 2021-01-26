@acceptance @checkout
Feature: Checkout

  Background: Logins to application and reset app state
    Given the user logins with valid credentials resetting app state

  Scenario: Verify that user can't checkout without entering first name info
    Given the user adds to cart the following items:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the user clicks cart button
    And the user clicks checkout button
    When the user fills the checkout form with:
      | First Name      |          |
      | Last Name       | Lawrence |
      | Zip Postal Code | 00005    |
    And the user clicks continue button
    Then verifies that the following error message is displayed in checkout form:
      """
      Error: First Name is required
      """
