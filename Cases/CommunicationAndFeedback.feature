Feature: Communication and Feedback
  Actor: user

  Scenario: Directly communicate with store owner and suppliers
    Given  I am a user logged in to the Sweet System using username "User1" and password "123"
    When I have an inquiry or need assistance
    Then I should be able to directly communicate with store owners and suppliers
    And I should be able to send a message describing my problem

  Scenario: Provide feedback on purchased products
    Given  I am a user logged in to the Sweet System using username "User1" and password "123"
    When I want to share my experience
    Then I should be able to provide feedback on the purchased product

  Scenario: Provide feedback on shared recipe
    Given I am a user logged in to the Sweet System using username "User1" and password "123"
    When I want to share my thoughts or suggestions to recipe i followed
    Then I should be able to leave feedback on the shared recipe

