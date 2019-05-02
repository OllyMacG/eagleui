@CreateEntity
Feature: Create Entity screen tests

  Background:
    Given the user is on the Create Entity page

  @High
  Scenario: All expected elements are present on the page
    Then all expected elements are displayed

  @High
  Scenario Outline: User selects all fields and continues
    Given the user selects "<entity_type>" as the entity type
    And the user enters "<entity_name>" as the entity name
    And the user selects the private box
    And the user enters "<blackbox_name>" as the black box name
    When the user selects the next button
    Then an entity is created

    Examples:
      | entity_type      | entity_name        | blackbox_name |
      | Business Process | Business ^& Entity | 99999999      |
      | Application      | 1                  | Blackbox\n    |
      | Hardware         |                    | Blackbox@     |

  @High
  Scenario: Entity type is required
    When the user enters "Database" as the entity name
    And the user enters "BlackBox" as the black box name
    And the user selects the next button
    Then no entity is created

  @High
  Scenario: Entity name is required
    When the user selects "Database" as the entity type
    And the user enters "BlackBox" as the black box name
    And the user selects the next button
    Then no entity is created

  @High
  Scenario: Private Box selected no entry in black box name
    Given the user selects "Business" as the entity type
    And the user enters "Business Entity" as the entity name
    And the user selects the private box
    When the user selects the next button
    Then no entity is created

  @Low
  Scenario: Entity name counter updates as text is entered
    Given the user enters "this sentence should has 33 chars" as the entity name
    Then the entity name counter should read "33/255"

  @Low
  Scenario: Test Entity Name only allows 255 characters
    Given the user enters "Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters" as the entity name
    Then the entity name should read "Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 characters Entity Name with 319 character"
    And the entity name counter should read "255/255"

  @Low
  Scenario: Test Black Box Name only allows 255 characters
    Given the user enters "Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters" as the black box name
    Then the black box name should read "Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box name with 314 characters Black Box"
    And the black box name counter should read "255/255"





