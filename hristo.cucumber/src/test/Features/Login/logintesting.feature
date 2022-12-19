Feature: Register functionality on nopcommerce webpage
  Verify the registration functionality on webpage

  Scenario Outline: Test the register functionality on nopcommerce webapge
    Given user navigate home page
    When user enters <firstName>,<lastName>,<email>,<password>and<confirmPassword>
    And click on register button
    Then the user will <status> register on the webpage

    Examples: 
      | firstName | lastName    | email               | password | confirmPassword | status         |
      | Hristo    | Gagachovski | hristo@iwec.com.mk  |   123456 |          123456 | successfully   |
      | Hristo    | Gagachovski | hristo;iwec.com.mk  |   123456 |          123456 | unsuccessfully |
      | Hristo    | Gagachovski | hristo@iwec.com.mk  |   123456 |         1234567 | unsuccessfully |
      | Hristo    | Gagachovski |                     |   123456 |          123456 | unsuccessfully |
      | Hristo    | Gagachovski | hristo1@iwec.com.mk |   123456 |          123456 | successfully   |
      | Hristo    | Gagachovski | hristo2@iwec.com.mk |   123456 |          123456 | successfully   |
