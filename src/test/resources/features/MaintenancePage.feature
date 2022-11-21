Feature: The client is in the application.

  Background:
    Given The client is on the login page.
    When Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Maintenance option.
    Then Administrator Access is displayed.

  Scenario: The client cancels maintenance menu.
    When The client clicks on Cancel button.
    Then The Home Page is displayed.

  Scenario: The client confirms maintenance menu with no password.
    When The client clicks on Confirm button.
    Then Required text is displayed.

  Scenario: The client confirms maintenance menu with wrong password.
    Given The client fills test as password.
    When The client clicks on Confirm button.
    Then Invalid credentials is displayed.

  Scenario: The client confirms maintenance menu with right password.
    Given The client fills admin123 as password.
    When The client clicks on Confirm button.
    Then Purge Employee Records is displayed.