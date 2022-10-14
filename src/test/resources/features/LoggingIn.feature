Feature: Testing client in application.

  Background:
    Given The client is on the login page.

  Scenario: The client fills username and password and then clicks on log in button.
    When Types "Admin" as username, "admin123" as password and clicks on log in button.
    Then The Home Page is going to be displayed.

  Scenario: The client only fills username field and tries to log in.
    When Types "Admin" as username and clicks on login button.
    Then The Login page show an error message.
