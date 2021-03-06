Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open site
    Then The browser title should be 'HOME_PAGE_TITLE'
    When I login as 'PITER'
    Then User's name should be 'PITER'
    And Interface should have all the necessary elements
    # TODO 'I expand Service subcategory in the header menu'
    When I expand Service subcategory in the header menu
    Then Service dropdown menu in header displays following options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_PAGES        |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I click on Service subcategory in the left section
    Then Service dropdown in left section displays following options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_PAGES        |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    And I click on Service subcategory in the header
    # TODO This method will be better with parameter
    When I open 'DIFFERENT_ELEMENTS' in Service menu of the header
    Then Interface on Different elements page contains all needed elements
    And There is a Right section
    And There is a Left section
    # TODO You should have possibility to pass different amount of elements
    # TODO Oh my, take a look on your HW-4 PO method. It has better name...
    When I click nature elements:
      | WATER |
      | WIND  |
    Then Nature elements are true on log:
      | WATER |
      | WIND  |
    When I select radio button:'SELEN'
    Then Radio button 'SELEN' is correct on log
    When I select 'YELLOW' from the color selection dropdown
    Then Color 'YELLOW' is correct on log
    When I click nature elements:
      | WATER |
      | WIND  |
    Then Nature elements are false on log:
      | WATER |
      | WIND  |
