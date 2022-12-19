Feature: Search store
  I want to verify the search functionality

  Scenario Outline: Search for avaliable and unavaliable products
    Given User navigate home page
    When User search for <item>
    And Click on search button
    Then verify the <status> of the search

    Examples: 
      | item      | status       |
      | AD_CS4_PH | successfuly  |
      | Patiki    | unsuccessful |
      | Levi's    | successful   |
      | Farmerki  | unsuccessful |
      | Farmerki2  | unsuccessful |
