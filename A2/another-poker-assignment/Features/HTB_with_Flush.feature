Feature: flush vs other hands

  Scenario: The HTB has a flush vs a straight
    Given The HTB has a flush vs straight "C3 C7 C2 C8 C10 C6 D7 S9 H8 S10"
    Then the HTB (flush) beats the AIP

  Scenario: The HTB has a flush vs a three of a kind
    Given The HTB has a flush vs threeOfAKind "C3 C7 C2 C8 C10 S6 H6 H9 D8 C6"
    Then the HTB (flush) beats the AIP

  Scenario: The HTB has a flush vs two pair
    Given The HTB has a flush vs twoPair "C3 C7 C2 C8 C10 H2 D2 C9 S9 SA"
    Then the HTB (flush) beats the AIP

  Scenario: The HTB has a flush vs a pair
    Given The HTB has a flush vs pair "C3 C7 C2 C8 C10 C5 S7 H9 D8 S5"
    Then the HTB (flush) beats the AIP

  Scenario: The HTB has a flush vs high Card
    Given The HTB has a flush vs highCard "C3 C7 C2 C8 C10 CQ H10 D4 C5 S9"
    Then the HTB (flush) beats the AIP
