@acceptance @products
Feature: Products

  Background: Logins to application and reset app state
    Given the user logins with valid credentials resetting app state

  Scenario: Verify that 'Price Low to High' filter from products list shows the lowest price item first
    When the user selects "Price (low to high)" product sort option
    Then verifies that the lowest price item is displayed first in the products list
