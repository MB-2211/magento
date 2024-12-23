Feature: SignIn
  As an existing user, I want to login to my account so I can access the platform
  I should not be able to login to my account using a wrong password

  Scenario: SignIn to my account
    Given the SignIn page
    When I fill in login details
    And I submit the SignIn form
    Then I should be logged in successfully

  Scenario: Fail to SignIn due to wrong password
    Given the SignIn page
    When I fill in invalid login details
    And I submit the SignIn form
    Then I should not be logged in to my account
    And I should see a failure message
