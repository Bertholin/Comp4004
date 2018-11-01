Feature: AIP straight vs other hands

  Scenario: The HTB has three of a kind vs straight
    Given The AIP has a straight vs threeOfAKind "S6 H6 H9 D8 C6 D6 D7 S9 H8 S10"
    And the AIP holds the straight
    Then the AIP (straight) beats the HTB

  Scenario: The HTB has a Tow Pair vs straight
    Given The AIP has a straight vs twoPair "H2 D2 C9 S9 SA D6 D7 S9 H8 S10"
    And the AIP holds the straight
    Then the AIP (straight) beats the HTB

  Scenario: The HTB has a Pair vs straight
    Given The AIP has a straight vs pair "C5 S7 H9 D8 S5 D6 D7 S9 H8 S10"
    And the AIP holds the straight
    Then the AIP (straight) beats the HTB

  Scenario: The HTB has a high Card vs straight 
    Given The AIP has a straight vs highCard "CQ H10 D4 C5 S9 D6 D7 S9 H8 S10"
    And the AIP holds the straight
    Then the AIP (straight) beats the HTB
