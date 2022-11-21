Feature: The client is in the application.

  Background:
    Given The client is on the login page.
    When Types Admin as username, admin123 as password and clicks on log in button.
    Then The Home Page is displayed

  Scenario: The client needs to go to Admin section.
    When The client clicks on Admin option.
    Then System Users is displayed.

  Scenario: The client needs to go to PIM section.
    Given The client clicks on Add button for leaving the home page.
    When The client clicks on PIM option.
    Then Employee Information is displayed.

  Scenario: The client needs to go to Leave section.
    When The client clicks on Leave option.
    Then Leave List is displayed.

  Scenario: The client needs to go to Time section.
    When The client clicks on Time option.
    Then Time is displayed.

  Scenario: The client needs to go to Recruitment section.
    When The client clicks on Recruitment option.
    Then Candidates is displayed.

  Scenario: The client needs to go to My Info section.
    When The client clicks on My Info option.
    Then PIM is displayed.

  Scenario: The client needs to go to Performance section.
    When The client clicks on Performance option.
    Then Employee Reviews is displayed.

  Scenario: The client needs to go to Dashboard section.
    When The client clicks on Dashboard option.
    Then Dashboard is displayed.

  Scenario: The client needs to go to Directory section.
    When The client clicks on Directory option.
    Then Directory is displayed.

  Scenario: The client needs to go to Maintenance section.
    When The client clicks on Maintenance option.
    Then Administrator Access is displayed.

  Scenario: The client needs to go to Buzz section.
    When The client clicks on Buzz option.
      Then Buzz is displayed.