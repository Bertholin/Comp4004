Feature: full house vs other hands

  Scenario: The HTB has a full house vs a flush
    Given The HTB has a full house vs flush "C8 S9 S8 H9 D9 C3 C7 C2 C8 C10"
    Then the HTB (full house) beats the AIP

  Scenario: The HTB has a full house vs a straight
    Given The HTB has a full house vs straight "C8 S9 S8 H9 D9 C6 D7 S9 H8 S10"
    Then the HTB (full house) beats the AIP

  Scenario: The HTB has a full house vs a three of a kind
    Given The HTB has a full house vs threeOfAKind "C8 S9 S8 H9 D9 S6 H6 H9 D8 C6"
    Then the HTB (full house) beats the AIP

  Scenario: The HTB has a full house vs two pair
    Given The HTB has a full house vs twoPair "C8 S9 S8 H9 D9 H2 D2 C9 S9 SA"
    Then the HTB (full house) beats the AIP

  Scenario: The HTB has a full house vs a pair
    Given The HTB has a full house vs pair "C8 S9 S8 H9 D9 C5 S7 H9 D8 S5"
    Then the HTB (full house) beats the AIP

  Scenario: The HTB has a full house vs high Card
    Given The HTB has a full house vs highCard "C8 S9 S8 H9 D9 CQ H10 D4 C5 S9"
    Then the HTB (full house) beats the AIP
