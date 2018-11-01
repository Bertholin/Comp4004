Feature: three of a kind vs other hands

  Scenario: The HTB has a three of a kind vs two pair
    Given The HTB has a three of a kind vs twoPair "S6 H6 H9 D8 C6 H2 D2 C9 S9 SA"
    Then the HTB (three of a kind) beats the AIP

  Scenario: The HTB has a three of a kind vs a pair
    Given The HTB has a three of a kind vs pair "S6 H6 H9 D8 C6 C5 S7 H9 D8 S5"
    Then the HTB (three of a kind) beats the AIP

  Scenario: The HTB has a three of a kind vs high Card
    Given The HTB has a three of a kind vs highCard "S6 H6 H9 D8 C6 CQ H10 D4 C5 S9"
    Then the HTB (three of a kind) beats the AIP