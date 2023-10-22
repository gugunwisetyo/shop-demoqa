Feature:Login Web ShopDemoQA
  Scenario: login valid test
    Given user enter url
    When user input valid username
    And user input valid password
    And user click login button
    Then user get text login

  Scenario: logout valid test
    Given user get text login
    When user click logout button
    Then user get text logout

  Scenario: login invalid test
    Given user input invalid username
    When user input valid password
    And user click login button
    Then user get text error invalid

  Scenario: blank password test
    Given user clear username
    When user clear password
    And user input valid username
    And user input blank password
    And user click login button
    Then user get text error blank