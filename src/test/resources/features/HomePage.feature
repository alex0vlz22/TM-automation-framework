Feature: The client is in the application.

  Background:
    Given The client is on the login page.
    When Types "Admin" as username, "admin123" as password and clicks on log in button.
    Then The Home Page is displayed.

  Scenario: The client gets personal details page after user creation.
    When The client goes to add a new user section.
    And The client creates a new user with all required fields.
    Then Personal details must be displayed.