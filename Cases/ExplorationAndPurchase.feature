Feature: Exploration and Purchase
  As a user,
  I want to browse and search for dessert recipes,
  filter recipes based on dietary needs or food allergies,
  and purchase desserts directly from store owners,
  so that I can easily find and buy desserts that suit my preferences.

  Scenario: Browse dessert recipes
    Given I am on the homepage
    When I navigate to the "Dessert Recipes" section
    Then I should see a list of available dessert recipes

  Scenario: Search for a specific dessert recipe
    Given I am on the "Dessert Recipes" section
    When I enter "Chocolate Cake" in the search bar
    And I click the search button
    Then I should see a list of dessert recipes that match "Chocolate Cake"

  Scenario: Filter recipes based on dietary needs
    Given I am on the "Dessert Recipes" section
    When I select "Gluten-Free" from the dietary needs filter
    And I apply the filter
    Then I should see a list of gluten-free dessert recipes

  Scenario: Filter recipes based on food allergies
    Given I am on the "Dessert Recipes" section
    When I select "Nut-Free" from the food allergies filter
    And I apply the filter
    Then I should see a list of nut-free dessert recipes

  Scenario: Combine filters for dietary needs and food allergies
    Given I am on the "Dessert Recipes" section
    When I select "Vegan" from the dietary needs filter
    And I select "Soy-Free" from the food allergies filter
    And I apply the filters
    Then I should see a list of vegan and soy-free dessert recipes

  Scenario: View dessert recipe details
    Given I am on the "Dessert Recipes" section
    When I click on a dessert recipe
    Then I should see the details of the selected dessert recipe

  Scenario: Add dessert to cart
    Given I am viewing the details of a dessert recipe
    When I click the "Add to Cart" button
    Then the dessert should be added to my shopping cart

  Scenario: View shopping cart
    Given I have added desserts to my shopping cart
    When I navigate to the "Shopping Cart" section
    Then I should see a list of desserts I have added to my cart

  Scenario: Purchase desserts
    Given I have desserts in my shopping cart
    When I proceed to checkout
    And I enter my payment and shipping information
    And I confirm the purchase
    Then the purchase should be completed
    And I should see a confirmation message

  Scenario: Receive order confirmation email
    Given I have completed a purchase
    When the purchase is confirmed
    Then I should receive an order confirmation email
