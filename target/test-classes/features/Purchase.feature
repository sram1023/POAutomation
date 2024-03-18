Feature: Search products in Amazon

  @ProductSearch
  Scenario: Validate the product iPhone
    Given the user land on the site
    And enter the product name "iphone" in the search bar
    And click on the search button
    Then verify that the first result contains the text "Apple iPhone"
