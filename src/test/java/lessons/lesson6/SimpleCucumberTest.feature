Feature:  JDI Home Page?
  Scenario:  Home Page test
    Given I'm on Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user PITER CHAILOVSKII is displayed on the header