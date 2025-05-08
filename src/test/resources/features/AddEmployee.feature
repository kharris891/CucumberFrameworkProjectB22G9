Feature: Add Employee

  Background:
    Given I am logged in as an admin user
    When I navigate to the Add Employee page

  @no_id @employee
  Scenario: Add employee without giving employee ID
    And I enter "John" in the first name field
    And I enter "Doe" in the last name field
    And I press Save
    Then employee should be added with an auto-generated employee ID

  @with_id @employee
  Scenario: Add employee while providing employee ID
    And I enter "Jane" in the first name field
    And I enter "Doe" in the last name field
    And I enter "123456" in the employee ID field
    And I press Save
    Then the employee should be added with the provided employee ID

  @error @employee
  Scenario Outline: Error messages are displayed for missing fields
    And I enter "<fn>" in the first name field
    And I enter "<ln>" in the last name field
    And I press Save
    Then I should see the error message "Required"
    Examples:
      | fn         | ln        |
      |            | Doe       |
      | John       |           |