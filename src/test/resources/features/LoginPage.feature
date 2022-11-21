Feature: Testing client in application.

  Background:
    Given The client is on the login page.

  Scenario: The client fills username and password and then clicks on log in button.
    When Types Admin as username, admin123 as password and clicks on log in button.
    Then The Home Page is displayed.

  Scenario: The client only fills username field and tries to log in.
    When Types Admin as username and clicks on login button.
    Then The Login page show an error message.

  Scenario: The client logs outta the application.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client logs outta the application.
    Then The client is on the login page.
