Feature: Testing client in application.

  Scenario: The client fills username and password and then clicks on log in button.
    Given The client is on the login page.
    When Types Admin as username, admin123 as password and clicks on log in button.
    Then The Home Page is displayed.

  Scenario: The client only fills username field and tries to log in.
    Given The client is on the login page.
    When Types Admin as username and clicks on login button.
    Then The Login page show an error message.

  Scenario: The client gets personal details page after user creation.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client goes to add a new user section.
    And The client creates a new user with Adam as first name and Leuff as last name required fields.
    Then Personal details is displayed.

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

  Scenario: The client needs to go to Admin section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Admin option.
    Then System users is displayed.

  Scenario: The client needs to go to PIM section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Add button for leaving the home page.
    When The client clicks on PIM option.
    Then Employee information is displayed.

  Scenario: The client needs to go to Leave section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Leave option.
    Then Leave list is displayed.

  Scenario: The client needs to go to Time section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Time option.
    Then Select Employee is displayed.

  Scenario: The client needs to go to Recruitment section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Recruitment option.
    Then Candidates is displayed.

  Scenario: The client needs to go to My Info section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on My Info option.
    Then Personal details is displayed.

  Scenario: The client needs to go to Performance section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Performance option.
    Then Employee Reviews is displayed.

  Scenario: The client needs to go to Dashboard section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Dashboard option.
    Then Launching Soon is displayed.

  Scenario: The client needs to go to Directory section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Directory option.
    Then Directory is displayed.

  Scenario: The client needs to go to Maintenance section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Maintenance option.
    Then Administrator Access is displayed.

  Scenario: The client cancels maintenance menu.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Maintenance option.
    And Administrator Access is displayed.
    When The client clicks on Cancel button.
    Then The Home Page is displayed.

  Scenario: The client confirms maintenance menu with no password.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Maintenance option.
    And Administrator Access is displayed.
    When The client clicks on Confirm button.
    Then Required text is displayed.

  Scenario: The client confirms maintenance menu with wrong password.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Maintenance option.
    And Administrator Access is displayed.
    When The client fills test as password.
    And The client clicks on Confirm button.
    Then Invalid credentials is displayed.

  Scenario: The client confirms maintenance menu with right password.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    And The client clicks on Maintenance option.
    And Administrator Access is displayed.
    When The client fills admin123 as password.
    And The client clicks on Confirm button.
    Then Purge Employee Records is displayed.

  Scenario: The client needs to go to Buzz section.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client clicks on Buzz option.
    Then Launching Soon is displayed.

  Scenario: The client logs outta the application.
    Given The client is on the login page.
    And Types Admin as username, admin123 as password and clicks on log in button.
    And The Home Page is displayed.
    When The client logs outta the application.
    Then The client is on the login page.
