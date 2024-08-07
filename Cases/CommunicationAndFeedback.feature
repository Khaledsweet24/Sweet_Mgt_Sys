Feature: Communication and Feedback
  As a user,
  I want to directly communicate with store owners and suppliers for inquiries or assistance,
  and provide feedback on purchased products and shared recipes,
  so that I can get the help I need and share my experiences with others.

  Scenario: Directly communicate with store owner
    Given I am viewing the details of a dessert recipe
    When I click the "Contact Store Owner" button
    Then I should see a form to send a message to the store owner
    When I fill out the form with my inquiry
    And I click the "Send" button
    Then my message should be sent to the store owner
    And I should see a confirmation message


  Scenario: Provide feedback on shared recipe
    Given I am viewing the details of a shared dessert recipe
    When I click the "Leave Feedback" button
    Then I should see a form to enter my feedback and rating
    When I fill out the form with my feedback and rating
    And I click the "Submit" button
    Then my feedback should be submitted
    And I should see a confirmation message

  Scenario: View feedback on purchased product
    Given I am viewing the details of a purchased dessert
    When there is feedback available
    Then I should see a list of feedback and ratings left by other users

  Scenario: View feedback on shared recipe
    Given I am viewing the details of a shared dessert recipe
    When there is feedback available
    Then I should see a list of feedback and ratings left by other users

  Scenario: Receive notification of response from store owner
    Given I have sent a message to a store owner
    When the store owner responds to my message
    Then I should receive a notification of the response
    And I should be able to view the response in my messages


  Scenario: Rate a store owner
    Given I have communicated with a store owner
    When I navigate to the "Messages" section
    And I select the conversation with the store owner
    Then I should see an option to rate the store owner
    When I click the "Rate" button
    Then I should see a form to enter my rating and comments
    When I fill out the form with my rating and comments
    And I click the "Submit" button
    Then my rating should be submitted
    And I should see a confirmation message
