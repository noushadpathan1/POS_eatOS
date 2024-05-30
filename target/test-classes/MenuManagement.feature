@menuManagement
Feature: Menu Management

  @menu
  Scenario Outline: Validate Menu Details for Different "<condition>"
    Given User is on Menu management Screen
    When User adds "<condition>" Menu details
    Then User gets errorMsg for "<condition>" Menu Details
    Examples:
      |       condition       |
     |    ValidMenuDetails   |
      |    EmptyMenuName      |
      |    NumMenuName        |

  @search @menu
  Scenario: Verify Search functionality on Menu
    Given User is on Menu management Screen
    When User Search menu on Search Bar
    Then User Able to Search Item on Menu

  @Category
  Scenario Outline: Validate Category Details for Different <condition>
    Given User is on Menu management Screen
    When User adds "<condition>" Category details
    Then User gets errorMsg for "<condition>" Category
    Examples:
      |       condition       |
    # |      ValidDetails     |
      |   ExistingCategoryName|
      |    EmptyCategoryName  |
      |   InvalidCategoryName |

  @search
  Scenario: Verify Search functionality on Category
    Given User is on Menu management Screen
    When User Search Category on Search Bar
    Then User Able to Search Item on Category

  @Modifiers
  Scenario Outline: Validate Modifiers Details for Different <condition>
    Given User is on Menu management Screen
    When User adds "<condition>" Modifiers details
    Then User gets errorMsg for "<condition>" Modifiers
    Examples:
      |       condition             |
    # |    ValidModifierDetails     |
      |    EmptyModifierName        |
      |    EmptyModifierOrderType   |

  @search
  Scenario: Verify Search functionality on Modifiers
    Given User is on Menu management Screen
    When User Search Modifier on Search Bar
    Then User Able to Search Item on Modifier

  @Addons
  Scenario Outline: Validate Addons Details for Different <condition>
    Given User is on Menu management Screen
    When User adds "<condition>" Addons details
    Then User gets errorMsg for "<condition>" Addons
    Examples:
      |       condition         |
    # |    ValidAddonsDetails   |
      |    EmptyAddonName       |
      |    EmptyAddonOrderType  |

  @search
  Scenario: Verify Search functionality on Addons
    Given User is on Menu management Screen
    When User Search Addons on Search Bar
    Then User Able to Search Item on Addons

  @Products
  Scenario Outline: Validate Products Details for Different "<condition>"
    Given User is on Menu management Screen
    When User adds "<condition>" Products details
    Then User gets errorMsg for "<condition>" Products
    Examples:
      |       condition            |
    # |   ValidProductsDetails     |
      |   EmptyProductsName        |
      |   ExistingProductName      |

  @search
  Scenario: Verify Search functionality on Products
    Given User is on Menu management Screen
    When User Search Products on Search Bar
    Then User Able to Search Item on Products

  @Ingredients
  Scenario Outline: Validate Ingredients Details for Different "<condition>"
    Given User is on Menu management Screen
    When User adds "<condition>" Ingredients details
    Then User gets errorMsg for "<condition>" Ingredients
    Examples:
      |       condition             |
    # |   ValidIngredientsDetails   |
      |   EmptyIngredientsName      |
      |   ExistingIngredientsName   |

  @search
  Scenario: Verify Search functionality on Ingredients
    Given User is on Menu management Screen
    When User Search Ingredients on Search Bar
    Then User Able to Search Item on Ingredients

  @Groups
  Scenario Outline: Validate Groups Details for Different "<condition>"
    Given User is on Menu management Screen
    When User adds "<condition>" Groups details
    Then User gets errorMsg for "<condition>" Groups
    Examples:
      |       condition           |
    # |    ValidGroupsDetails     |
      |    EmptyGroupsName        |
      |    ExistingGroupsName     |

  @search
  Scenario: Verify Search functionality on Groups
    Given User is on Menu management Screen
    When User Search Groups on Search Bar
    Then User Able to Search Item on Groups








