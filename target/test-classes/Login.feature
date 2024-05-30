@login @All
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


  Scenario Outline: Validate Login Functionality
    When User enter "<condition>" Credentials
    Then User gets "<condition>" errorMsg
    Examples:
      |       condition     |
      |    InvalidUsername  |
      |    InvalidPassword  |
      |    EmptyUsername    |
      |    EmptyPassword    |


  @login

  Scenario Outline: Validate Login Functionality
    When User enter "<condition>" Credentials
    Then User gets "<condition>" errorMsg
    Examples:
      |       condition     |
      |    InvalidUsername  |
#      |    InvalidPassword  |
#      |    EmptyUsername    |
#      |    EmptyPassword    |
#      |    ValidCredentials |

  @sample
  Scenario Outline: Validate Login Functionality
    When User enter "<condition>" Credentials
    Then User gets "<condition>" errorMsg
    Examples:
      |       condition     |
      |    EmptyFields      |
      |    ValidCredentials |



 # Scenario Outline: Validate Login Functionality with Valid PIN
  #  When User enter username as "<username>"
   # And User enter password as "<password>"
    #And User Tap on Login Button
 #   And User enter valid Pin
  #  Then User should get successfully loggedin
   # Examples:
    #  | username         | password      |
     # | np3@eigital.com  | @Password123  |