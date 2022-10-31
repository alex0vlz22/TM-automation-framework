Feature: The client is in the application.

  Scenario: The client gets personal details page after user creation.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client goes to add a new user section.
    And The client creates a new user with all required fields.
    Then Personal details must be displayed.