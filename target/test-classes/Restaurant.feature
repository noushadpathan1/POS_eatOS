@regression
Feature: Restaurant

  @guestbook
  Scenario Outline: Validate Guestbook Details for Different <condition>
    Given User is on Restaurant  Screen
    When User adds "<condition>" Guestbook details
    Then User gets errorMsg for "<condition>" Guestbook
    Examples:
      |     condition            |
      | EmptyGuestbookDetails    |
      | MandatoryGuestbookDetails|
      | SearchGuestbook          |
      | ArchiveGuestbook         |

  @search
  Scenario: Verify Search functionality on Guestbook
    Given User is on Restaurant  Screen
    When User Search GuestBook on Search Bar
    Then User Able to Search Item on GuestBook

    @scheduleInfo
  Scenario Outline: Validate Schedule Info Details for Different <condition>
    Given User is on Restaurant  Screen
    When User adds "<condition>" Schedule Info details
    Then User gets errorMsg for "<condition>" Schedule Info
    Examples:
      |         condition             |
    # |    ValidScheduleInfoDetails   |
      |    EmptyScheduleInfoName      |

  @search
  Scenario: Verify Search functionality on Schedule Info
    Given User is on Restaurant  Screen
    When User Search Schedule Info on Search Bar
    Then User Able to Search Item on Schedule Info

  @locationSettings
  Scenario: Verify Buttons on Location Settings
    Given User is on Restaurant  Screen
    When User Tap on Buttons
    Then Button should clickable

    @timedPricing
  Scenario Outline: Validate Timed Pricing Details for Different <condition>
    Given User is on Restaurant  Screen
    When User adds "<condition>" Timed Pricing details
    Then User gets errorMsg for "<condition>" Timed Pricing
    Examples:
      |         condition             |
    # |    ValidTimedPricingDetails   |
      |    EmptyTimedPricingName      |

  @search
  Scenario: Verify Search functionality on Timed Pricing
    Given User is on Restaurant  Screen
    When User Search Timed Pricing on Search Bar
    Then User Able to Search Item on Timed Pricing