Feature: Use Table Test

  Scenario: User Table Page test
    Given I am on Home Page
    And I login as user 'PITER'
    When I click on Service button in Header
    And I click on User Table button in Service dropdown
    Then 'USER_TABLE' page is opened
    And '6' NumberType Dropdowns are displayed on User Table Page
    And '6' User names are displayed on Users Table on User Table Page
    And '6' Description images are displayed on Users Table on User Table Page
    And '6' Description texts under images are displayed on Users Table on User Table Page
    And '6' checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Desciption                       |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select Vip checkbox for 'SERGEY'
    Then I check condition in log section changed to 'true'
    When I click on dropdown in column Type for user 'ROMAN'
    Then Droplist contains values:
      | Admin   |
      | User    |
      | Manager |