Feature: User status feature

@wip
  Scenario: verify user status

    Given the user "Librarian" on the homepage
    When the user click users moudle
    And the user click Status dropdown
    Then the user should see the following options on userStatus:

      | ACTIVE   |
      | INACTIVE |



