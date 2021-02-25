@10
Feature: As a librarian, I should be able to see book records on user page

  Scenario: Default value verification
    Given User  librarian is on the homepage
    When User click on "Users" link
    Then User verify that the default record is 10

  Scenario: Verify the <count> options
    Given User  librarian is on the homepage
    When User click on "Users" link
    Then User sees show records for the following count


      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

