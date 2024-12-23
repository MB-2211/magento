Feature: SignUp
  As a new user, I want to create an account with valid details so that I can access the platform
  I should not be able to create an account using an email id associated with any existing user

  Scenario: SignUp with valid details
    Given the SignUp page
    When I fill in valid account details
    And I submit the SignUp form
    Then my account should be created successfully
    And I should see a confirmation message

  Scenario: Fail to SignUp due to existing email id
    Given the SignUp page
    When I fill in valid account details
    And I submit the SignUp form
    Then no new account should be created
    And I should see a failure message of email id already existing
