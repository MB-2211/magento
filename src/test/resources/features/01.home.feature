Feature: Home
  From the home page, be able to go to SignUp and SignIn pages

  Scenario: Go to the SignUp page
    Given the Home page
    When I click the SignUp link
    Then I go to the SignUp page

  Scenario: Go to the SignIn page
    Given the Home page
    When I click the SignIn link
    Then I go to the SignIn page
