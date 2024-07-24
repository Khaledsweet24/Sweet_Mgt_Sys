Feature: User Signup to Sweet System
  Actor: regular user

  Scenario: Valid credentials
    Given user is not registered in the Sweet System
    When user enters a username "Admin" and a password "123"
    Then user is registered into the Sweet System
    And a successful signup message will appear

  Scenario: Invalid username
    Given user is not registered in the Sweet System
    When user enters a username "123456789" and a password "123"
    Then user is not registered in the Sweet System
    And  wrong credential message will appear

