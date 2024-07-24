Feature: User login to Sweet System
  Actor: regular user

  Scenario: Valid Credentials
    Given user is not in the Sweet system

    When user enters username "Admin" and password "123"
    Then user is now in the system
    And a welcome message will appear

  Scenario: Invalid Password
    Given user is not in the Sweet system
    When user enters username "Admin" and password "1234"
    Then user is not logged in to the system
    And a wrong password message will appear

  Scenario: Invalid Username
    Given user is not in the Sweet system
    When user enters username "admin" and password "123"
    Then user is not logged in to the system
    And a wrong credential message will appear

