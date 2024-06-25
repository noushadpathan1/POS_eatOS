@payments @regression
Feature: Payments

  @taxes
  Scenario Outline: Validate Tax Details  <condition>
    Given User is on Payments Screen
    When User adds "<condition>" Tax details
    Then User gets errorMsg for "<condition>" Tax Details
    Examples:
      |       condition      |
      |    ValidTaxDetails   |
      |    EmptyTaxName      |
      |    EmptyTaxAmount    |
      |    EmptyAllFields    |

  @search
  Scenario: Verify Search functionality on Taxes
    Given User is on Payments Screen
    When User Search Tax on Search Bar
    Then User Able to Search Item on Tax

  @discount
  Scenario Outline: Validate Discount Details  <condition>
    Given User is on Payments Screen
    When User adds "<condition>" Discount details
    Then User gets errorMsg for "<condition>" Discount Details
    Examples:
      |       condition          |
    # |    ValidDiscountDetails  |
      |    EmptyDiscountName     |
      |    EmptyDiscountAmount   |
      |    EmptyAllFields        |

  @search
  Scenario: Verify Search functionality on Discounts
    Given User is on Payments Screen
    When User Search Discount on Search Bar
    Then User Able to Search Item on Discount

  @serviceCharge
  Scenario Outline: Validate Service Charge Details  <condition>
    Given User is on Payments Screen
    When User adds "<condition>" Service Charge details
    Then User gets errorMsg for "<condition>" Service Charge Details
    Examples:
      |          condition            |
    # |    ValidServiceChargeDetails  |
      |    EmptyServiceChargeName     |
      |    EmptyServiceChargeAmount   |
      |    EmptyAllFields             |

  @search
  Scenario: Verify Search functionality on Service Charge
    Given User is on Payments Screen
    When User Search Service Charge on Search Bar
    Then User Able to Search Item on Service Charge
