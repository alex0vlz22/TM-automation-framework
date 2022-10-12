Feature: Testing client can logging in into the application.
  Scenario: The client fills username and password and then clicks on log in button.
    Given The client is on the login page.
    When Types "Admin" as username, "admin123" as password and clicks on log in button.
    Then The Home Page is going to be displayed.