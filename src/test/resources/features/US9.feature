Feature: Show User functionality

  @wip
  Scenario: verify user categories
    Given the user is on the homepage
    When the user click Users module
    And the user click User Group dropdown
    Then the user should see the following options:
      | ALL       |
      | Librarian |
      | Students  |