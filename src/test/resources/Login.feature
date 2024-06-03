@loginModule @regression
Feature: Login scenarios

  @createAnAccount
  Scenario Outline: Create An Account With Negative Scenario
    Given User opens the Applications
    And Tap on Create an Account
    When User enter "<condition>" in Create An Account screen
    Then User should get a warning message "<condition>"
    Examples:
      | condition     |
      | VerifyTitle   |
      | emptyFirstName|
      | emptyLastName |
      | emptyEmail    |
      | emptyPhoneNum |
      | emptyPassword |
      | restaurantName|
      | allEmptyFields|


    @login
  Scenario Outline: Validate Login Functionality
    When User enter "<condition>" Credentials
    Then User gets "<condition>" errorMsg
    Examples:
      |       condition     |
      |    InvalidUsername  |
      |    InvalidPassword  |
      |    EmptyUsername    |
      |    EmptyPassword    |

  @sample
  Scenario Outline: Validate Login Functionality
    When User enter "<condition>" Credentials
    Then User gets "<condition>" errorMsg
    Examples:
      |       condition     |
      |    EmptyFields      |
      |    ValidCredentials |

