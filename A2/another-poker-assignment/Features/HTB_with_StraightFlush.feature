Feature: Straight Flush vs other hands

  Scenario: The HTB has a Straight Flush vs four of a Kind
    Given The HTB has a Straight Flush vs fourOfAKind "D6 D7 D9 D8 D5 H6 D6 C6 S6 S10"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs full house
    Given The HTB has a Straight Flush vs fullHouse "D6 D7 D9 D8 D5 C8 S9 S8 H9 D9"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs a flush
    Given The HTB has a Straight Flush vs flush "D6 D7 D9 D8 D5 C6 C7 C2 C8 C10"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs a straight
    Given The HTB has a Straight Flush vs straight "D6 D7 D9 D8 D5 C6 D7 S9 H8 S10"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs a three of a kind
    Given The HTB has a Straight Flush vs threeOfAKind "D6 D7 D9 D8 D5 S6 H6 H9 D8 C6"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs two pair
    Given The HTB has a Straight Flush vs twoPair "D6 D7 D9 D8 D5 H2 D2 C9 S9 SA"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs a pair
    Given The HTB has a Straight Flush vs pair "D6 D7 D9 D8 D5 C5 S7 H9 D8 S5"
    Then the HTB (Straight Flush) beats the AIP

  Scenario: The HTB has a Straight Flush vs high Card
    Given The HTB has a Straight Flush vs highCard "D6 D7 D9 D8 D5 CQ H10 D4 C5 S9"
    Then the HTB (Straight Flush) beats the AIP
