Feature: Homework2

  Scenario: Register account test
    Given user is on the registration page
    When user enters valid registration details
    And user submits the registration form
    Then user should be registered successfully