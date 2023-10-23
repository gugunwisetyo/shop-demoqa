Feature: Add Product ShopDemoQA
  Scenario: add two product test
    Given user enter url shop
    When user choose first product
    And user choose color
    And user choose size
    And user click add to cart
    And user back to list product
    And user choose second product
    And user choose color
    And user choose size
    And user click add to cart
    And user click view cart
    Then user get text cart
  Scenario: invalid checkout test
    Given user get text cart
    When user click checkout
    And user input first name
    And user input last name
    And user choose region
    And user input address
    And user input city
    And user choose province
    And user input postcode
    And user input phone number
    And user input email
    And user click place order
    Then user get text incomplete
  Scenario: valid checkout test
    Given user get text incomplete
    When user mark check TNC
    And user click place order
    Then user get text order complete