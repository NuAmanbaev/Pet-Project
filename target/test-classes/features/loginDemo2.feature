Feature: test login functionality
  @loginDemo
  Scenario: check login successful with valid credentials
    Given user is on sauce demo login page
    When user provides a valid user name
    And user provides valid password
    And user clicks on login button
    Then verify user successfully logged in

    @invalidLogin
    Scenario: invalid user login
      Given user is on sauce demo login page
      When user provides a invalid user name
      And user provides invalid password
      And user clicks on login button
      Then verify error message
