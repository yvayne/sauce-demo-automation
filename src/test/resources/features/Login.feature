@acceptance @login
Feature: Login

  Scenario: Verify that user can login with valid credentials
    Given the user goes to login page
    When the user enters valid credentials
    And the users clicks login button
    Then verifies that products page is displayed
