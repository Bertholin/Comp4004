Feature: four of a Kind vs other hands

  Scenario: The HTB has a four of a Kind vs full house
    Given The HTB has a four of a Kind vs fullHouse "H6 D6 C6 S6 S10 C8 S9 S8 H9 D9"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs a flush
    Given The HTB has a four of a Kind vs flush "H6 D6 C6 S6 S10 C3 C7 C2 C8 C10"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs a straight
    Given The HTB has a four of a Kind vs straight "H6 D6 C6 S6 S10 C6 D7 S9 H8 S10"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs a three of a kind
    Given The HTB has a four of a Kind vs threeOfAKind "H6 D6 C6 S6 S10 S6 H6 H9 D8 C6"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs two pair
    Given The HTB has a four of a Kind vs twoPair "H6 D6 C6 S6 S10 H2 D2 C9 S9 SA"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs a pair
    Given The HTB has a four of a Kind vs pair "H6 D6 C6 S6 S10 C5 S7 H9 D8 S5"
    Then the HTB (four of a Kind) beats the AIP

  Scenario: The HTB has a four of a Kind vs high Card
    Given The HTB has a four of a Kind vs highCard "H6 D6 C6 S6 S10 CQ H10 D4 C5 S9"
    Then the HTB (four of a Kind) beats the AIP
