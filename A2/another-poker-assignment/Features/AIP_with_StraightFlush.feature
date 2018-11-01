Feature: AIP Straight Flush vs other hands

  Scenario: The HTB has a four of a Kind vs Straight Flush 
    Given The AIP has a Straight Flush vs fourOfAKind "H6 D6 C6 S6 S10 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a full house vs Straight Flush 
    Given The AIP has a Straight Flush vs fullHouse "C8 S9 S8 H9 D9 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a flush vs Straight Flush
    Given The AIP has a Straight Flush vs flush "C6 C7 C2 C8 C10 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a straight vs Straight Flush
    Given The AIP has a Straight Flush vs straight "C6 D7 S9 H8 S10 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has three of a kind vs Straight Flush
    Given The AIP has a Straight Flush vs threeOfAKind "S6 H6 H9 D8 C6 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a Tow Pair vs Straight Flush
    Given The AIP has a Straight Flush vs twoPair "H2 D2 C9 S9 SA D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a Pair vs Straight Flush
    Given The AIP has a Straight Flush vs pair "C5 S7 H9 D8 S5 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB

  Scenario: The HTB has a high Card vs Straight Flush 
    Given The AIP has a Straight Flush vs highCard "CQ H10 D4 C5 S9 D6 D7 D9 D8 D5"
    And the AIP holds the Straight Flush
    Then the AIP (Straight Flush) beats the HTB
