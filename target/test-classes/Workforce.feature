@workforce @All
Feature: Workforce Feature

  @taxes
  Scenario Outline: Create New Employee
    Given User is on Workforce Screen
    When User adds "<condition>" Employee details
    Then User gets errorMsg for "<condition>" Employee Details
    Examples:
      |       condition      |
      |    EmptyAllFields    |
      |    EmptyFirstName    |
      |    EmptyLastName     |
      |    EmptyEmail        |
      |    EmptyPhoneNum     |
      |    EmptyEmpID        |
      |    ExistingPIN       |

  @search
  Scenario: Verify Search functionality on Workforce
    Given User is on Workforce Screen
    When User Search Employee on Search Bar
    Then User Able to Search Item on Employee