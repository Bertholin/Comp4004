Feature: straight vs other hands

  Scenario: The HTB has a straight vs a three of a kind
    Given The HTB has a straight vs threeOfAKind "C6 D7 S9 H8 S10 S6 H6 H9 D8 C6"
    Then the HTB (straight) beats the AIP

  Scenario: The HTB has a straight vs two pair
    Given The HTB has a straight vs twoPair "C6 D7 S9 H8 S10 H2 D2 C9 S9 SA"
    Then the HTB (straight) beats the AIP

  Scenario: The HTB has a straight vs a pair
    Given The HTB has a straight vs pair "C6 D7 S9 H8 S10 C5 S7 H9 D8 S5"
    Then the HTB (straight) beats the AIP

  Scenario: The HTB has a straight vs high Card
    Given The HTB has a straight vs highCard "C6 D7 S9 H8 S10 CQ H10 D4 C5 S9"
    Then the HTB (straight) beats the AIP
