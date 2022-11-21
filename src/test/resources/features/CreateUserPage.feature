Feature: The client is in the application.

  Scenario: The user is created and displayed on UI.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client goes to add a new user section.
    And An ID is available for the user creation.
    And The client creates a new user with Rodolf as first name and Vinsmoke as last name required fields.
    When The client is back to home page.
    And The client search by employee id.
    Then The just created user is going to be found.

